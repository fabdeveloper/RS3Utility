package src.entityservices;

import java.util.List;

import src.gestor.IGestorE;
import src.inter.IServiceLocator;

public interface IEntityServices<E> {
	
	public E getTransferObject();
	public IServiceLocator getServiceLocator();
	public IGestorE<E> getGestorE();
	
	public void create(E e);
	public E read(Integer id);
	public E update(E e);
	public void delete(E e);
	public List<E> readAll();
	
	public E createNamedQuery(String queryname, String paramname, String paramvalue);
	public List<E> createNamedQueryListResult(String queryname, String paramname, String paramvalue);
	public List<E> createNamedQueryListResultIntParam(String queryname, String paramname, Integer paramvalue);

	

}
