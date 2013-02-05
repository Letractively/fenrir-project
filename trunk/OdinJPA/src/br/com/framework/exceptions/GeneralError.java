package br.com.framework.exceptions;

public class GeneralError extends Error {

	private static final long serialVersionUID = 1937312442231919401L;

	public static final String NO_FILE_PROJECT = "no exists file \"configuration.properties\" in project ";
	
	public static final String NO_CLASSE = "Nenhuma classe de entidade encontrada";
	
	private String message;
	
	public GeneralError(String message) {
		setMessage(message);
	}
	
	@Override
	public String getMessage() {
		return message;
	}

	private void setMessage(String message) {
		this.message = message;
	}
	
}
