package com.fenrir.jpa.component;

import java.util.List;
//import java.util.Map;

import javax.persistence.EntityManagerFactory;

/**
 * Interface de Configuração.
 * 
 * @author Felipe de Andrade Batista
 * @version  1.0.0
 */
public interface Configuration {

	public List<String> getEntities();
	
	public String getStringXMLPersistence();
	
	public EntityManagerFactory createEntityManagerFactory();
}
