package EShop.entityservices.dao.entityloader.loader;

import javax.inject.Inject;

import EShop.entityservices.dao.xls.excel.AbstractDaoExcel;



public abstract class AbstractEntityLoader<E, P> extends AbstractDaoExcel<E> implements IEntityLoader<E, P> {
	

	
	@Inject
	private IBinder_EntityToParent<E, P> binder;

	@Override
	public void loadFromXLSFile() {
 		createList();
	}

	@Override
	public void bindToParentEntity(P parent_entity) {
		setList(getBinder().bindToParentEntity(getList(), parent_entity));
	}

	public IBinder_EntityToParent<E, P> getBinder() {
		return binder;
	}

	public void setBinder(IBinder_EntityToParent<E, P> binder) {
		this.binder = binder;
	}
	
	

}
