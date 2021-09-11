package EShop.entityservices.dao.entityloader.loader;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import src.entity.Product;


@RequestScoped
public class ProductToParentBinder implements IBinder_EntityToParent<Product, Product> {

	@Override
	public List<Product> bindToParentEntity(List<Product> entityList, Product entity_parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
