package com.fenrir.framework.interfaces;

import org.hibernate.SessionFactory;

/**
 * Obriga quem implementar essa interface retornar SessionFactory do hibernate
 * 
 * @author  Felipe de Andrade Batista
 * @version 1.0.0
 */
public interface ReturnsSessionFactory {
	
	/**
	 * @uml.property  name="sessionFactory"
	 * @uml.associationEnd  
	 */
	public SessionFactory getSessionFactory();
	public SessionFactory getSessionFactory(String schema);
	
}
