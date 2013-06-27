package com.fenrir.jpa.component;

import java.io.File;
import java.util.Map;
import java.util.Properties;

/**
 * Interface de propriedades da JPA.
 * 
 * @author Felipe de Andrade Batista
 * @version 1.0.0
 */
public interface JPAproperties {
	
	public String getProperti(String key);
	
	public File getPropertiesFile();
	
	public Properties getProperties();
	
	public Map<String, String> getPersistenceProperties();
	
}
