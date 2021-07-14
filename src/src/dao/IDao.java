package src.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface IDao<T> {

	public abstract EntityManager getEntityManager();
	
	public T createNamedQuery(String queryname, String paramname, String paramvalue);
	public T createNamedQuery2P(String queryname, String param1name, String param1value, String param2name, String param2value);
	public Integer createNamedQuery2PintResult(String queryname, String param1name, String param1value, String param2name, String param2value);

	public List<T> createNamedQueryListResult(String queryname, String paramname, String paramvalue);
	public List<T> createNamedQueryListResultIntParam(String queryname, String paramname, Integer paramvalue);	
	public List<T> createNamedQueryListResultDateParam(String queryname, String paramname, java.util.Date paramvalue);
	
	public List<T> createNamedQueryLimited(String queryname, Integer limit);


	public abstract void persist(T entity);

	public abstract T merge(T entity);

	public abstract void remove(T entity);

	public abstract T find(Object id);

	public abstract int count();

	public abstract List<T> getAll();

}