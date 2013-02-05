package br.com.mijolnir.framework;

import java.util.Properties;

/**
 * 
 * @author Felipe de Andrade Batista
 *
 */
public class EtexProperties extends Properties {

	private static final long serialVersionUID = -7746309646392646309L;

	/**
	 * 
	 * 
	 * NOME DO ARQUIVO DE CONFIGURAÇÃO PADRÃO
	 *  
	 * 
	 */
	public static final String CONFIGURATION_PROPERTIES = "configuration.properties";
	
	//local padrão do arquivo de configuração em projetos web
	public static final String WEB_INF_CONFIGURATION_PROPERTIES = "/WEB-INF/configuration.properties";
	
	/**
	 * 
	 * 
	 *  PROPIEDADES DO ARQUIVO DE CONFIGURAÇÃO PROPERTIES
	 *  
	 *  
	 */
	
	//Essa propiedade diz qual é o pacote padrão dos Beans percistentes
	public static final String ETEX_PACKAGE_PERSISTENT = "etex.package.persistent";
	
	//pasta padrão do arquivo persistence.xml
	public static final String META_INF = "META-INF";
	
	
	/**
	 * 
	 *  PROPIEDADES DE CONTROLE DO DESENVOLVIMENTO
	 *  
	 */
	public static final boolean PRODUCAO = false;

	
}
