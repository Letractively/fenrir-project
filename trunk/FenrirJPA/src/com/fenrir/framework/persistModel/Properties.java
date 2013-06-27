package com.fenrir.framework.persistModel;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Classe de entidade de propriedades
 * 
 * @author Felipe de Andrade Batista
 * @version 1.0.0
 */
public class Properties {
	
	@XStreamAlias("properties")
	private Property property;

	
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	
}
