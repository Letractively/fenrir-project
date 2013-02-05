package br.com.framework.persistModel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("persistence")
public class Persistencia {
	
	@XStreamAsAttribute
	@XStreamAlias("xmlns")
	private String xmlns;
	
	@XStreamAsAttribute
	@XStreamAlias("version")
	private String version;
	
	@XStreamAlias("persistence-unit")
	private PersistenceUnit persistenceUnit;
	
	public Persistencia() {
		setXmlns("http://java.sun.com/xml/ns/persistence");
		setVersion("1.0");
	}

	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public PersistenceUnit getPersistenceUnit() {
		return persistenceUnit;
	}

	public void setPersistenceUnit(PersistenceUnit persistenceUnit) {
		this.persistenceUnit = persistenceUnit;
	}
	
}
