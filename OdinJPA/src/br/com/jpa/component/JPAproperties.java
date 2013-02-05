package br.com.jpa.component;

import java.io.File;
import java.util.Map;
import java.util.Properties;

public interface JPAproperties {
	
	public String getProperti(String key);
	
	public File getPropertiesFile();
	
	public Properties getProperties();
	
	public Map<String, String> getPersistenceProperties();
	
}
