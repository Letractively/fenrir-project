package br.com.framework.persistModel;

import com.thoughtworks.xstream.annotations.XStreamAlias;

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
