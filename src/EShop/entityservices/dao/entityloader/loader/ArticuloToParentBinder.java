package EShop.entityservices.dao.entityloader.loader;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import src.entity.Articulo;
import src.entity.Product;

@RequestScoped
public class ArticuloToParentBinder implements IBinder_EntityToParent<Articulo, Product> {

	@Override
	public List<Articulo> bindToParentEntity(List<Articulo> entityList, Product entity_parent) {


		for(Articulo art : entityList) {
			art.setProduct(entity_parent);
		}	
		
		return entityList;
	}

}
