package com.fenrir.framework.exceptions;

/**
 * Classe de Exceção para <b>propriedades</b> não configuradas.
 * 
 * @author Felipe de Andrade Batista
 * @version 1.0.0
 */
public class NoPropertiesConfiguration extends Exception {

	private static final long serialVersionUID = -8359388256405000339L;
	
	public static final String ETEX_PACKAGE_PERSISTENT = "no faund property \"etex.package.persistent\" in the file configuration.properties"; 
	
	/**
	 * @uml.property  name="exception"
	 */
	private String exception;
	
	public NoPropertiesConfiguration(String exception) {
		setException(exception);
	}
	
	@Override
	public String getMessage() {
		return getException();
	}

	/**
	 * @return
	 * @uml.property  name="exception"
	 */
	private String getException() {
		return exception;
	}

	/**
	 * @param exception
	 * @uml.property  name="exception"
	 */
	private void setException(String exception) {
		this.exception = exception;
	}
	
}
