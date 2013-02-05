package br.com.framework.hibernateTemplates;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.framework.InitialContex;
import br.com.framework.interfaces.Contex;


/**
 * Classe abstrada com metodos genericos. Classe usada para herança.
 * 
 * @author Felipe Andrade Batista
 * 
 * @param <T>
 * @param <ID>
 */
public abstract class GenericDAO<T> implements CRUD<T> {

	private Contex contex;
	private Session session;
	private Class<?> classe;

	{
		setContex(InitialContex.getInstance());
	}

	public Criteria getCriteria() {
		return getContex().getSession().createCriteria(getObjectClass());
	}

	public GenericDAO(Class<?> classe) {
		this.classe = classe;
	}
	
	@Override
	public List<T> listarTodos() {
		try {
			setSession(getContex().getSession());
			getSession().beginTransaction();
			Criteria query = getSession().createCriteria(classe);
			return query.list();
		} finally {
			getSession().close();
		}
	}

	@Override
	public void deletar(T objeto) {

		try {
			setSession(getContex().getSession());
			getSession().beginTransaction();
			getSession().delete(objeto);
			getSession().getTransaction().commit();
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			getSession().close();
		}
	}

	@Override
	public void salvarOuAtualizar(T objeto) {

		try {
			setSession(getContex().getSession());
			getSession().beginTransaction();
			getSession().saveOrUpdate(objeto);
			getSession().getTransaction().commit();
		} catch (HibernateException e) {
			getSession().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			getSession().close();
		}
	}

	public void setSession(Session session) {

		try {
			if (!getSession().isOpen()) {
				this.session = session;
			}
		} catch (Exception e) {
			this.session = session;
		}
	}

	public Session getSession() {
		return session;
	}

	public Class<?> getObjectClass() {
		return classe;
	}

	public Contex getContex() {
		return contex;
	}

	public void setContex(Contex contex) {
		this.contex = contex;
	}
}
