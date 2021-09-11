package EShop.entityservices.dao.entityloader.loader;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import org.apache.poi.ss.usermodel.Row;

import src.entity.Articulo;
import src.entity.Oferta;

@SessionScoped
public class OfertasLoader extends AbstractEntityLoader<Oferta, Articulo> implements Serializable {


	@Override
	public void loadFromDB() {
		setList(getServiceLocator().getOfertaServices().readAll());
	}



}
