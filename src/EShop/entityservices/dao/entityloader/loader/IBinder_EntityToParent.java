package EShop.entityservices.dao.entityloader.loader;

import java.util.List;

public interface IBinder_EntityToParent<E, P> {
	
	public List<E> bindToParentEntity(List<E> entityList, P entity_parent);

}
