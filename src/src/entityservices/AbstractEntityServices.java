package src.entityservices;

import java.util.List;

import javax.inject.Inject;

import src.gestor.IGestorE;
import src.inter.IServiceLocator;

public abstract class AbstractEntityServices<E> implements IEntityServices<E> {
	
	@Inject
	private IGestorE<E> gestor;
	@Inject
	private IServiceLocator serviceLocator;

	@Override
	public E getTransferObject() {
		return gestor.getFactory().crear();
	}
	
	@Override
	public IGestorE<E> getGestorE(){
		return gestor;
	}
	
	@Override
	public IServiceLocator getServiceLocator(){
		return serviceLocator;
	}

	@Override
	public void create(E e) {
		gestor.getDao().create(e);
	}

	@Override
	public E read(Integer id) {
		return gestor.getDao().find(id);		
	}

	@Override
	public E update(E e) {
		return gestor.getDao().edit(e);
	}

	@Override
	public void delete(E e) {
		gestor.getDao().remove(e);
	}

	@Override
	public List<E> readAll() {
		return gestor.getDao().getAll();
	}
	
	@Override
	public E createNamedQuery(String queryname, String paramname, String paramvalue){
		return gestor.getDao().createNamedQuery(queryname, paramname, paramvalue);		
	}

	@Override
	public List<E> createNamedQueryListResult(String queryname,	String paramname, String paramvalue) {
		return gestor.getDao().createNamedQueryListResult(queryname, paramname, paramvalue);		
	}

	@Override
	public List<E> createNamedQueryListResultIntParam(String queryname,	String paramname, Integer paramvalue) {
		return gestor.getDao().createNamedQueryListResultIntParam(queryname, paramname, paramvalue);		
	}



}
