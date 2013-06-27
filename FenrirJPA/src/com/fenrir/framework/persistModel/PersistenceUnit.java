package com.fenrir.framework.persistModel;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Classe de entidade de Unidade de Persistencia
 * 
 * @author Felipe de Andrade Batista
 * @version 1.0.0
 */
public class PersistenceUnit {

	@XStreamAsAttribute
	@XStreamAlias("name")
	private String name;
	
	@XStreamAsAttribute
	@XStreamAlias("transaction-type")
	private String transactionType;

	@XStreamImplicit(itemFieldName="class")
	private List<String> classe;
	
	@XStreamAlias("properties")
	private List<Property> properties;
	
	public PersistenceUnit() {
		setName("manager1");
		setTransactionType("RESOURCE_LOCAL");
		setClasse(new ArrayList<String>());
	}
	
	public String getName() {
		return name;
	}

	//public void setName(String name) {
        public final void setName(String name) {
		this.name = name;
	}

	public String getTransactionType() {
		return transactionType;
	}

	//public void setTransactionType(String transactionType) {
        public final void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public List<String> getClasse() {
		return classe;
	}

	//public void setClasse(List<String> classe) {
        public final void setClasse(List<String> classe) {
		this.classe = classe;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
}
