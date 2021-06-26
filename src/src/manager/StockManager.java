package src.manager;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import src.entity.Oferta;
import src.exception.ConsumeStockException;
import src.exception.DBException;
import src.inter.IServiceLocator;

@Dependent
public class StockManager implements IStockManager, Serializable {
	

	private static final long serialVersionUID = 1L;

	@Inject
	private IServiceLocator serviceLocator;

	private Oferta oferta;
	
	private void publish(String msg) {
		System.out.println(msg);
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setServiceLocator(IServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}


	@Override
	public Boolean consumirStock(Integer oferta_id, Integer unidades) {
		Boolean ok = true;
		// check availability
		int nuevoStock = disponible(oferta_id) - unidades;
		// consume stock
		if(nuevoStock >= 0){
			try{
				updateStock(oferta, nuevoStock);		

			}catch(Throwable t){
				throw new DBException("error consumiendo stock", t);
			}
			
		}else{
			ok = false;
			throw new ConsumeStockException("insufficient stock available").setOferta(oferta).setDisponible(oferta.getStock());			
		}
		return ok;
	}

	@Override
	public Boolean recuperarStock(Integer oferta_id, Integer unidades) {
		String msg = "StockManager.recuperarStock() - ";
		Boolean ok = true;
		int nuevoStock = disponible(oferta_id) + unidades;
		publish(msg + ", nuevoStock = " + nuevoStock);
		try{
			updateStock(oferta, nuevoStock);		

		}catch(Throwable t){
			throw new DBException("error recuperando stock", t);
		}
		return ok;
	}

	@Override
	public Integer disponible(Integer oferta_id) {
		String msg = "StockManager.disponible() - ";
		Integer result = 0;
		load(oferta_id);
		if(oferta != null)result = oferta.getStock();

		publish(msg + ", disponible= " + result);
		return result;
	}

	@Override
	public IServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	@Override
	public Integer disponible() {
		Integer result = 0;
		if(oferta != null)result = oferta.getStock();

		return result;

	}

	@Override
	public void load(Integer oferta_id) {
		oferta = getServiceLocator().getOfertaServices().read(oferta_id);		
	}

	@Override
	public Oferta updateStock(Oferta oferta, Integer unidades) {
		String msg = "StockManager.updateStock() - ";
		Oferta ofertaActualizada = oferta.clone();
		ofertaActualizada.setStock(unidades);		
		oferta = getServiceLocator().getOfertaServices().update(ofertaActualizada);
		publish(msg + ", actualizado stock = " + oferta.getStock());
		return oferta;
	}

	@Override
	public Oferta getOferta() {
		return oferta;
	}

	@Override
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

}
