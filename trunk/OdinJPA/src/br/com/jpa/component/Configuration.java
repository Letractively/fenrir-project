package br.com.jpa.component;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;


public interface Configuration {

	public List<String> getEntities();
	
	public String getStringXMLPersistence();
	
	public EntityManagerFactory createEntityManagerFactory();
}
