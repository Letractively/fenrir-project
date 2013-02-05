package br.com.jpa.component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.framework.EtexProperties;
import br.com.framework.exceptions.GeneralError;
import br.com.framework.exceptions.NoPropertiesConfiguration;
import br.com.framework.persistModel.PersistenceUnit;
import br.com.framework.persistModel.Persistencia;
import br.com.framework.persistModel.Property;
import br.com.framework.util.ScannerClass;

import com.thoughtworks.xstream.XStream;

public class ConfigPersistence implements Configuration {

	/**
	 * Armazena todas as entidades persistentes da aplicação
	 */
	private List<String> entities;
	
	/**
	 * Armazena todas as classes da aplicação.
	 * Forma temporaria
	 */
	private List<String> appAllClass;
	
	private static ConfigPersistence configuration;
	
	/**
	 * Flag para indicar se é um projeto web ou nao.
	 */
	private boolean webProject = false;
	
	/**
	 * armazena em forma de string o <b>persistence.xml</b> do JPA
	 */
	private String stringXmlPersistence;
	
	/**
	 * unit name do <b>persistence.xml</b>
	 */
	private static final String PERSISTENCE_UNIT_NAME = "manager";
	
	/**
	 * 
	 * Retorna a instancia de um configuration.
	 * padrão singleton
	 * 
	 * @return
	 */
	public static Configuration getInstanceConfiguration() {
		
		if(getConfiguration() == null) {
			setConfiguration(new ConfigPersistence());
		}
		
		return getConfiguration();
	}
	
	private ConfigPersistence() {
		
		try {
			ConfigPersistence.class.getClassLoader().loadClass("javax.servlet.ServletContext");
			setWebProject(true);
		} catch (ClassNotFoundException e) {
			System.out.println("Não é um projeto web JSF");
		}
		
		loadEntities();
		generatePersistenceXml();
	}
	
	/**
	 * 
	 * Classe responsavel por pegar uma string
	 * e salvar em <b>persistence.xml</b> na pasta META-INF/ do projeto
	 * 
	 * @param xml
	 */
	private void generateFileXml(String xml) {
		
		String path = null;
		
//		if(isWebProject()) {
//			
//			System.out.println("webProject");
//			
//			FacesContext facesContext = FacesContext.getCurrentInstance();  
//			ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
//			path = servletContext.getRealPath("META-INF/") + "/persistence.xml";
//		} else {
//			URL url =  this.getClass().getClassLoader().getResource("META-INF/");
//			path = url.getPath() + "/persistence.xml";
//		}
		
		File file = (File)ScannerClass.getMapDiretorios().get(EtexProperties.META_INF);
		
		if(file == null) {
			throw new Error("Não encontrado as pasta META-INF no projeto!");
		}
		
		path = file.getPath() + "/persistence.xml";
		
		System.out.println(path);
		
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(path);
			writer.write(xml);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void generatePersistenceXml() {
		generateFileXml(getStringXMLPersistence());
	}
	
	public String getStringXMLPersistence() {
		
		if(this.stringXmlPersistence != null) {
			return this.stringXmlPersistence; 
		}
		
		XStream xstream = new XStream();
		xstream.processAnnotations(Persistencia.class);
		
		Persistencia persistenca = new Persistencia();
		
		//carrega todas a antidades
		PersistenceUnit persistenceUnit = new PersistenceUnit();
		List<String> classes = new ArrayList<String>();
		
		for(String classe : getEntities()) {
			classes.add(new String(classe));
		}
		
		persistenceUnit.setClasse(classes);
		persistenceUnit.setName(PERSISTENCE_UNIT_NAME);
		
		List<Property> properties = new ArrayList<Property>();
		final JPAproperties jpaProperties = JPAComponentProperties.getInstanceJPAComponentProperties();
		Set<String> keys = jpaProperties.getPersistenceProperties().keySet();
		
		for(String key : keys) {
			properties.add(new Property(key, jpaProperties.getProperti(key)));
		}
		
		//monta toda estrutura
		persistenceUnit.setProperties(properties);
		persistenca.setPersistenceUnit(persistenceUnit);
		
		this.stringXmlPersistence = xstream.toXML(persistenca);
		
		return this.stringXmlPersistence;
	}
	
	/**
	 * 
	 * Carrega todas as classes persistentes da aplicação
	 * que estão no pacote indicado no arquivo de propiedades.
	 * 
	 */
	private void loadEntities() {
		
		final JPAproperties properties = JPAComponentProperties.getInstanceJPAComponentProperties();
		
		//carrega todas as classes da applicação
		setAppAllClass(ScannerClass.getAllClassApp());
		
		setEntities(new ArrayList<String>());
		String pacote =  properties.getProperti(EtexProperties.ETEX_PACKAGE_PERSISTENT);

		if(pacote == null) {
			try {
				throw new NoPropertiesConfiguration(NoPropertiesConfiguration.ETEX_PACKAGE_PERSISTENT);
			} catch (NoPropertiesConfiguration e) {
				e.printStackTrace();
				return;
			}	
		}
		
		
		for (String strClasse : getAppAllClass()) {

			strClasse = strClasse.trim().substring(0, strClasse.trim().length() - 6).replace("/", ".");
			
			if ((strClasse.length() >= pacote.length()) && strClasse.substring(0, pacote.length()).equals(pacote)) {
				
				try {
					
					Class<?> classe = Class.forName(strClasse);
					
					for (Annotation annotation : classe.getDeclaredAnnotations()) {
						
						if (annotation instanceof Entity) {
							
							getEntities().add(classe.toString().replace("class ", ""));
							
						}
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		/**
		 * Libera o objeto da referencia para a VM
		 * fazer sua coleta.
		 */
		setAppAllClass(null);
		
		if(getEntities().size() == 0) {
			throw new Error(GeneralError.NO_CLASSE);
		}
	}

	/**
	 * retorna um EntityManagerFactory
	 */
	public EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	/**
	 * Retorna todas as classes de entidade
	 * persistentes da aplicação
	 */
	@Override
	public List<String> getEntities() {
		return entities;
	}

	public static ConfigPersistence getConfiguration() {
		return configuration;
	}

	public static void setConfiguration(ConfigPersistence configuration) {
		ConfigPersistence.configuration = configuration;
	}

	public void setEntities(List<String> entities) {
		this.entities = entities;
	}

	public List<String> getAppAllClass() {
		return appAllClass;
	}

	public void setAppAllClass(List<String> appAllClass) {
		this.appAllClass = appAllClass;
	}

	public boolean isWebProject() {
		return webProject;
	}

	public void setWebProject(boolean webProject) {
		this.webProject = webProject;
	}

	public String getStringXmlPersistence() {
		return stringXmlPersistence;
	}

	public void setStringXmlPersistence(String stringXmlPersistence) {
		this.stringXmlPersistence = stringXmlPersistence;
	}

}
