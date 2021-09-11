package EShop.entityservices.dao.entityloader.loader;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import src.entity.Articulo;
import src.entity.Product;

@SessionScoped
public class ArticulosLoader extends AbstractEntityLoader<Articulo, Product> implements Serializable {

	@Override
	public void loadFromDB() {
		setList(getServiceLocator().getArticuloServices().readAll());
	}



}
