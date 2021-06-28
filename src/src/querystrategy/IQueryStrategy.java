package src.querystrategy;

import java.util.List;

import src.inter.IServiceLocator;


public interface IQueryStrategy<E> {
	
	public List<E> executeStrategy();
	
	public IServiceLocator getServiceLocator();
	public void setServiceLocator(IServiceLocator serviceLocator);


}
