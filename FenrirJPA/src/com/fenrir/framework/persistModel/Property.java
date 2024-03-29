package com.fenrir.framework.persistModel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Classe de entidade de propriedade
 * 
 * @author Felipe de Andrade Batista
 * @version 1.0.0
 */
@XStreamAlias("property")
public class Property {
	
	@XStreamAsAttribute
	@XStreamAlias("name")
	private String name;
	
	@XStreamAsAttribute
	@XStreamAlias("value")
	private String value;

	public Property(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
