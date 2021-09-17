package EShop.entityservices.dao.entityloader.loader;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;

import src.entity.Articulo;
import src.entity.Oferta;

@SessionScoped
public class OfertasLoader extends AbstractEntityLoader<Oferta, Articulo> implements Serializable {


	@Override
	public void loadFromDB() {
		setList(getServiceLocator().getOfertaServices().readAll());
	}
	
	@Override
	public void persistList() {
		actualizarFechas();		
		super.persistList();		
	}
	
	private void actualizarFechas() {
		Date fechaCreacion = new Date();
		for(Oferta ofer : getList()) {
			if(ofer.getCreationDate() == null) {
				ofer.setCreationDate(fechaCreacion);
			}			
		}		
	}



}
