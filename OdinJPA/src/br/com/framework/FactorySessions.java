package br.com.framework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.framework.interfaces.ReturnsConfiguration;
import br.com.framework.interfaces.ReturnsSessionFactory;
import br.com.framework.interfaces.SetProperties;
import br.com.framework.interfaces.UserSessionProvides;


/**
 * 
 * @author Felipe de Andrade Batista
 * 
 */
public class FactorySessions implements SetProperties, UserSessionProvides,
		ReturnsConfiguration, ReturnsSessionFactory {

	private Configuration configuration;
	private List<Class> listAnnotedClass;
	private Map<String, String> mapProperties;
	private static SessionFactory SingleSessionFactory;
	private static Map<String, SessionFactory> mapSessionFactory;

	{
		setMapSessionFactory(new HashMap<String, SessionFactory>());
	}
	
	public FactorySessions(Map<String, String> mapProperties,
			List<Class> listAnnotedClass) {
		setMapProperties(mapProperties);
		setListAnnotedClass(listAnnotedClass);
		
		System.out.println("Classes persistentes carregadas apartir do pacote : " + EtexProperties.ETEX_PACKAGE_PERSISTENT);
		
		//for(Class cl : listAnnotedClass) {
		//	System.out.println(cl.getName());
		//}
	}

	/**
	 * Carrega todas as propiedades
	 */
	@Override
	public void loadConfigProperties() {

		Set<String> keys = getMapProperties().keySet();
		for (String key : keys) {
			getConfiguration().setProperty(key, getMapProperties().get(key));
		}

	}


	/**
	 * carrega todas as classes annotadas
	 */
	@Override
	public void loadAnnotedClass() {
		
		setConfiguration(new Configuration());

		for (Class<?> classe : getListAnnotedClass()) {
			getConfiguration().addAnnotatedClass(classe);
		}
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	public Configuration getConfiguration() {
		
		if (configuration == null) {
			loadAnnotedClass();
			loadConfigProperties();
		}

		return configuration;
	}

	public Session getSession() {
		loadAnnotedClass();
		loadConfigProperties();
		return getSessionFactory().openSession();
	}

	/**
	 * Obtem a Sessão atual
	 * 
	 * @param schema
	 * @return
	 */
	public Session getSession(String schema) {
		loadAnnotedClass();
		loadConfigProperties();
		return getSessionFactory(schema).getCurrentSession();
	}

	/**
	 * Retorna uma factory de um schema. se n�o existir cria uma nova factory
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public SessionFactory getSessionFactory(String schema) {

		SessionFactory sessionFactory = null;

		if (getMapSessionFactory().containsKey(schema)) {
			sessionFactory = getMapSessionFactory().get(schema);
		} else {

			//TODO : corrigir a criação do schema em versões futuras da aplicação
			//createSchema(schema, getConfiguration());
			
			getConfiguration().setProperty("hibernate.default_schema", schema);
			sessionFactory = getConfiguration().buildSessionFactory();
			getMapSessionFactory().put(schema, sessionFactory);
			
			System.out.println("Registrando o schema " + schema);
			

		}

		return sessionFactory;
	}
	
	/**
	 * 
	 * Cria um schema no banco de dados, cria somente se o schema
	 * não estiver criado no banco de dados
	 * 
	 * @param schema
	 */
//	private void createSchema(String schema, Configuration cfg) {
//		
//		String sqlValida = null;
//		String sqlCria = null;
//		Properties pt = cfg.getProperties();
//		
//		if(pt.get("hibernate.dialect") != null) {
//			
//			if (pt.get("hibernate.dialect").equals("org.hibernate.dialect.PostgreSQLDialect")) {
//				sqlValida = "SELECT * FROM pg_tables where schemaname = '"+ schema + "';";
//				sqlCria = "CREATE SCHEMA " + schema + ";";
//				createSchema(sqlValida, sqlCria, schema);
//			}
//			//TODO : impelementar para outros dialetos
//			else {
//				throw new Error("hibernate.dialect=" + pt.get("hibernate.dialect") + "N�o suportado pelo framework!");
//			}
//			
//		} else {
//			throw new Error("Propiedade hibernate.dialect n�o foi encontrada no arquivo de configura��o");
//		}
//	}

	/**
	 * Cria o schema no banco de dados
	 * @param sqlValida
	 * @param sqlCria
	 * @param schema
	 */
//	private void createSchema(String sqlValida, String sqlCria, String schema) {
//		Session session = null;
//		try {
//			session = getSession();
//			
//			if (session.createSQLQuery(sqlValida).list().size() == 0) {
//				session.close();
//				session = getSession();
//				
//				session.beginTransaction();
//				session.createSQLQuery(sqlCria).executeUpdate();
//				session.getTransaction().commit();
//				
//			} else {
//				System.err.println("O Schema : " + schema + " J� foi criado.");
//			}
//			
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//
//	}
	
	/**
	 * Retorna uma factory se n�o existir cria uma nova factory.
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public SessionFactory getSessionFactory() {

		if (getSingleSessionFactory() == null) {
			setSingleSessionFactory(getConfiguration().buildSessionFactory());
		}

		return getSingleSessionFactory();
	}

	public static void main(String... args) {

	}

	public void setListAnnotedClass(List<Class> listAnnotedClass) {
		this.listAnnotedClass = listAnnotedClass;
	}

	public List<Class> getListAnnotedClass() {
		return listAnnotedClass;
	}

	public void setMapProperties(Map<String, String> mapProperties) {
		this.mapProperties = mapProperties;
	}

	public Map<String, String> getMapProperties() {
		return mapProperties;
	}

	public static void setMapSessionFactory(
			Map<String, SessionFactory> mapSessionFactory) {
		FactorySessions.mapSessionFactory = mapSessionFactory;
	}

	public static Map<String, SessionFactory> getMapSessionFactory() {
		return mapSessionFactory;
	}

	public static void setSingleSessionFactory(
			SessionFactory singleSessionFactory) {
		SingleSessionFactory = singleSessionFactory;
	}

	public static SessionFactory getSingleSessionFactory() {
		return SingleSessionFactory;
	}

}
