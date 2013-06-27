package com.fenrir.framework.interfaces;

import org.hibernate.Session;

/**
 * interface que força quem implementa-la a fornecer sessoes para o usuario
 * 
 * @author  Felipe de Andrade Batista
 * @version 1.0.0
 */
public interface UserSessionProvides {
	
	/**
	 * @uml.property  name="session"
	 * @uml.associationEnd  
	 */
	public Session getSession();
	public Session getSession(String schema);
	
}
