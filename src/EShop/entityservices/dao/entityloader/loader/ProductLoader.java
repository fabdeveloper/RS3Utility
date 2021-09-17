package EShop.entityservices.dao.entityloader.loader;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;

import src.entity.Product;

@SessionScoped
public class ProductLoader extends AbstractEntityLoader<Product, Product> implements Serializable{

	@Override
	public void loadFromDB() {
		setList(getServiceLocator().getProductServices().readAll());
		
	}
	
	@Override
	public void persistList() {
		actualizarFechas();		
		super.persistList();		
	}
	
	private void actualizarFechas() {
		Date fechaCreacion = new Date();
		for(Product prod : getList()) {
			if(prod.getCreationDate() == null) {
				prod.setCreationDate(fechaCreacion);
			}			
		}		
	}



}
