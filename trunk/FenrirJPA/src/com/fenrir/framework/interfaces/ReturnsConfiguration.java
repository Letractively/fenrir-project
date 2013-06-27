package com.fenrir.framework.interfaces;

import org.hibernate.cfg.Configuration;

/**
 * Interface que forãa implementar o retorno de configurações do hibernate 
 * para criação de sessão factory
 * 
 * @author  Felipe de Andrade Batista
 * @version 1.0.0
 */
public interface ReturnsConfiguration {
	
	/**
	 * @uml.property  name="configuration"
	 * @uml.associationEnd  
	 */
	Configuration getConfiguration();
	
}
