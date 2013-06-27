package com.fenrir.framework.interfaces;

import java.util.List;

/**
 * Classe para abstração do método para criação da lista de classes anotadas
 * 
 * @author Felipe de Andrade Batista
 * @version 1.0.0
 */
public abstract class Contex implements UserSessionProvides, SetProperties, ReturnsConfiguration, ReturnsSessionFactory {
	
	public abstract List<Class> getAnnothedClass();
	
}

