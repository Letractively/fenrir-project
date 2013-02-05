package br.com.jpa.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


import br.com.framework.EtexProperties;
import br.com.framework.exceptions.GeneralError;
import br.com.framework.util.ScannerClass;
/**
 * 
 * Classe responsavel por tratar as propiedades que estão no arquivo
 * <b>configuration.properties</b>
 * 
 * @author Felipe de Andrade Batista
 *
 */
public class JPAComponentProperties implements JPAproperties {
	
	/**
	 * Armazena o arquivo de propiedades
	 * configuration.properties
	 */
	private Properties properties;
	
	/**
	 * Propiedades do persistence.xml
	 */
	private Map<String, String> persistenceProperties;
	
	private static JPAComponentProperties jpaComponentProperties;
	
	/**
	 * 
	 * Inicializa as principais propiedades
	 * 
	 */
	{
		setProperties(new Properties());
		setPersistenceProperties(new HashMap<String, String>());
	}
	
	/**
	 * Retorna uma instancia unica
	 * @return
	 */
	public static JPAComponentProperties getInstanceJPAComponentProperties() {
		
		if(jpaComponentProperties == null) {
			setJpaComponentProperties(new JPAComponentProperties());
		}
		
		return getJpaComponentProperties();
	}
	
	private JPAComponentProperties() {
		loadConfigProperties();
	}
	
	@Override
	public String getProperti(String key) {
		return getPersistenceProperties().get(key);
	}
	
	private void loadConfigProperties() {
		
		File file = getPropertiesFile();
		FileInputStream fileInputStream = null;
		
		try {
			
			fileInputStream = new FileInputStream(file);
			
			getProperties().load(fileInputStream);
			Set<String> properties = getProperties().stringPropertyNames();
			
			for(String string : properties) {
				getPersistenceProperties().put(string, (String)getProperties().get(string));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
				file = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public File getPropertiesFile() {
		
		File file = null;
		
		ScannerClass.getAllClassApp();
		
		try {
			
//			if (EtexProperties.PRODUCAO) {
//				
//				FacesContext facesContext = FacesContext.getCurrentInstance();  
//				ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
//				
//				file = new File(servletContext.getRealPath("/WEB-INF/configuration.properties"));
//				
//			} else {
//				
//				file = new File("C:\\Users\\Thiago\\workspace\\VendaExterna\\WebContent\\WEB-INF\\configuration.properties");
//			}
			
			file = (File)ScannerClass.getMapDiretorios().get(EtexProperties.CONFIGURATION_PROPERTIES);
//		
			System.out.println(file);
			
			if(file == null || !file.exists()) {
				throw new GeneralError(GeneralError.NO_FILE_PROJECT);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return file;
	}

	@Override
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}


	private static JPAComponentProperties getJpaComponentProperties() {
		return jpaComponentProperties;
	}

	private static void setJpaComponentProperties(JPAComponentProperties jpaComponentProperties) {
		JPAComponentProperties.jpaComponentProperties = jpaComponentProperties;
	}

	@Override
	public Map<String, String> getPersistenceProperties() {
		return persistenceProperties;
	}

	public void setPersistenceProperties(Map<String, String> persistenceProperties) {
		this.persistenceProperties = persistenceProperties;
	}
	
}
