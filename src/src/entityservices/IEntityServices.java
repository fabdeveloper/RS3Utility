package src.entityservices;

import java.util.List;

import src.dao.IDao;
import src.gestor.IGestorE;
import src.inter.IServiceLocator;

public interface IEntityServices<E> {
	
	public E getTransferObject();
	public IServiceLocator getServiceLocator();
	public IGestorE<E> getGestorE();
	public IDao<E> getDao();
	
	public void persist(E e);
	public E read(Integer id);
	public E merge(E e);
	public void delete(E e);
	public List<E> readAll();
	
	public E createNamedQuery(String queryname, String paramname, String paramvalue);
	public E createNamedQuery2P(String queryname, String param1name, String param1value, String param2name, String param2value);
	public Integer createNamedQuery2PintResult(String queryname, String param1name, String param1value, String param2name, String param2value);
	public List<E> createNamedQueryListResult(String queryname, String paramname, String paramvalue);
	public List<E> createNamedQueryListResultIntParam(String queryname, String paramname, Integer paramvalue);
	public List<E> createNamedQueryListResultDateParam(String queryname, String paramname, java.util.Date paramvalue);
	public List<E> createNamedQueryLimited(String queryname, Integer limit);


	

}
