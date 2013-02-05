package br.com.framework.interfaces;

import java.util.List;

public abstract class Contex implements UserSessionProvides, SetProperties, ReturnsConfiguration, ReturnsSessionFactory {
	
	public abstract List<Class> getAnnothedClass();
	
}

