package br.com.framework.interfaces;

import org.hibernate.cfg.Configuration;

/**
 * interface que forãa implementar o retorno de configurações do hibernate para criação de sessão factory
 * @author  Felipe de Andrade Batista
 */
public interface ReturnsConfiguration {
	
	/**
	 * @uml.property  name="configuration"
	 * @uml.associationEnd  
	 */
	Configuration getConfiguration();
	
}
