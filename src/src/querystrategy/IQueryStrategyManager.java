package src.querystrategy;

import java.util.List;




public interface IQueryStrategyManager<E> {
	
	public List<E> getList();
	public void loadList();

	
	public IQueryStrategy<E> getStrategy();
	public void setStrategy(IQueryStrategy<E> strategy);
	
	public void reset();

}
