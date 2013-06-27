package com.fenrir.framework;

import java.io.File;

/**
 * Interface para implementação de manipulação das propriedades do
 * arquivo de Contexto.
 * 
 * @author  Felipe de Andrade Batista
 * @version 1.0.0
 */
public interface Contex {
	
    /**
     * Método a ser implementado para uso do <b>Arquivo de Propriedades</b>
     * 
     * @return File - O arquivo de propriedades.
     */
    public File getPropertiesFile();
	
}
