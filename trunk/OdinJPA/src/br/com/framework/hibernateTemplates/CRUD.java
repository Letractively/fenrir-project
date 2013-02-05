package br.com.framework.hibernateTemplates;

import java.io.Serializable;
import java.util.List;

/**
 * Interface padrão do DAO
 * @author Felipe de Andrade Batista
 *
 * @param <T>
 * @param <ID>
 */
interface CRUD <T> {
	public List<T> listarTodos();
	public void salvarOuAtualizar(T objeto);
	public void deletar(T objeto);
}
