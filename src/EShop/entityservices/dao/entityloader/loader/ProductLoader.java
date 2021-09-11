package EShop.entityservices.dao.entityloader.loader;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import src.entity.Product;

@SessionScoped
public class ProductLoader extends AbstractEntityLoader<Product, Product> implements Serializable{

	@Override
	public void loadFromDB() {
		setList(getServiceLocator().getProductServices().readAll());
		
	}



}
