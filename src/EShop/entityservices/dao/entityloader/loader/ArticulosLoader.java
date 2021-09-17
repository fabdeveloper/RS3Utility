package EShop.entityservices.dao.entityloader.loader;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;

import src.entity.Articulo;
import src.entity.Product;

@SessionScoped
public class ArticulosLoader extends AbstractEntityLoader<Articulo, Product> implements Serializable {

	@Override
	public void loadFromDB() {
		setList(getServiceLocator().getArticuloServices().readAll());
	}
	
	@Override
	public void persistList() {
		actualizarFechas();		
		super.persistList();
		
	}
	
	private void actualizarFechas() {
		Date fechaCreacion = new Date();
		for(Articulo arti : getList()) {
			if(arti.getCreationDate() == null) {
				arti.setCreationDate(fechaCreacion);
			}			
		}		
	}




}
