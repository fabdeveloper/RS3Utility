package src.entityservices;

import java.util.List;

import javax.inject.Inject;

import src.dao.IDao;
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
	public IDao<E> getDao(){
		return getGestorE().getDao();
	}
	
	@Override
	public IServiceLocator getServiceLocator(){
		return serviceLocator;
	}

	@Override
	public void persist(E e) {
		gestor.getDao().persist(e);
	}

	@Override
	public E read(Integer id) {
		return gestor.getDao().find(id);		
	}

	@Override
	public E merge(E e) {
		return gestor.getDao().merge(e);
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
	public E createNamedQuery2P(String queryname, String param1name, String param1value, String param2name, String param2value){
		return getDao().createNamedQuery2P(queryname, param1name, param1value, param2name, param2value);		
	}
	
	@Override
	public Integer createNamedQuery2PintResult(String queryname, String param1name, String param1value, String param2name, String param2value){
		return getDao().createNamedQuery2PintResult(queryname, param1name, param1value, param2name, param2value);		
	}	
	

	@Override
	public List<E> createNamedQueryListResult(String queryname,	String paramname, String paramvalue) {
		return gestor.getDao().createNamedQueryListResult(queryname, paramname, paramvalue);		
	}

	@Override
	public List<E> createNamedQueryListResultIntParam(String queryname,	String paramname, Integer paramvalue) {
		return gestor.getDao().createNamedQueryListResultIntParam(queryname, paramname, paramvalue);		
	}
	
	@Override
	public List<E> createNamedQueryListResultDateParam(String queryname, String paramname, java.util.Date paramvalue) {
		return gestor.getDao().createNamedQueryListResultDateParam(queryname, paramname, paramvalue);		
	}
	
	@Override
	public List<E> createNamedQueryLimited(String queryname, Integer limit) {
		return gestor.getDao().createNamedQueryLimited(queryname, limit);
	}



}
