package src.dao;

import javax.enterprise.context.Dependent;
import src.entity.Product;

@Dependent
public class ProductDao extends AbstractDao<Product>{

	public ProductDao() {
		super(Product.class);
	}


}
