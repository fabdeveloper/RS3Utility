package EShop.entityservices.dao.entityloader.loader;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import src.entity.Articulo;
import src.entity.Oferta;


@RequestScoped
public class OfertaToParentBinder implements IBinder_EntityToParent<Oferta, Articulo> {

	@Override
	public List<Oferta> bindToParentEntity(List<Oferta> entityList, Articulo entity_parent) {
		for(Oferta ofe : entityList) {
			ofe.setArticulo(entity_parent);
		}	
		
		return entityList;
	}

}
