package br.com.mijolnir.framework;

import java.io.File;

/**
 * 
 * @author  Felipe de Andrade
 * @version 1.0.0
 * Interface que sera implementada para pegar
 * o arquivo de propriedades.
 */
public interface Contex {
	/**
         * Método à ser implementado com o
         * intuito de trabalhar com o arquivo de 
         * propriedades usando java.io.File .
         * 
         * @return java.io.File
         */
	public File getPropertiesFile();
	
}
