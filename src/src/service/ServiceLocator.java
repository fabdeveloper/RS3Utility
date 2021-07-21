package src.service;

/**************************************************************************/
/*	Service Locator
 * 	
 * 	
 * 
 * 	Author : Fabricio Tosi
 */
/**************************************************************************/

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import src.entity.Articulo;
import src.entity.Cart;
import src.entity.CartItem;
import src.entity.DeliveryDetails;
import src.entity.Etiqueta;
import src.entity.Grupo;
import src.entity.Oferta;
import src.entity.Order;
import src.entity.Product;
import src.entity.PurchaseStatus;
import src.entity.User;
import src.entityservices.IEntityServices;
import src.inter.IEncripter;
import src.inter.IServiceLocator;


@Singleton
public class ServiceLocator implements IServiceLocator, Serializable{
	

	private static final long serialVersionUID = 10L;

	@Resource
	private SessionContext sessionContext;
	
	
	@PersistenceContext(unitName="RS3_PU")
	private EntityManager entityManager;
	
	@Inject
	private IEncripter encripter;
	@Inject
	private IEntityServices<Grupo> grupoServices;
	@Inject
	private IEntityServices<User> userServices;
	@Inject
	private IEntityServices<Product> productServices;
	@Inject
	private IEntityServices<Articulo> articuloServices;
	@Inject
	private IEntityServices<Oferta> ofertaServices;
	@Inject 
	private IEntityServices<Cart> cartServices;
	@Inject
	private IEntityServices<CartItem> cartItemServices;
	@Inject 
	private IEntityServices<Order> orderServices;
	@Inject 
	private IEntityServices<PurchaseStatus> purchaseStatusServices;
	@Inject 
	private IEntityServices<DeliveryDetails> deliveryDetailsServices;
	@Inject 
	private IEntityServices<Etiqueta> etiquetaServices;
	


	
	@Override 
	public SessionContext getSessionContext(){
		return sessionContext;
	}
	
	@Override
	public EntityManager getEntityManager(){
		return entityManager;
	}

	@Override
	public IEncripter getEncripter() {
		return encripter;
	}
	
	@Override
	public IEntityServices<Grupo> getGrupoServices(){
		return grupoServices;
	}
	
	@Override
	public IEntityServices<User> getUserServices() {
		return userServices;
	}

	@Override
	public IEntityServices<Product> getProductServices() {
		return productServices;
	}

	@Override
	public IEntityServices<Articulo> getArticuloServices() {
		return articuloServices;
	}
	
	@Override
	public IEntityServices<Oferta> getOfertaServices() {
		return ofertaServices;
	}
	
	@Override
	public IEntityServices<Cart> getCartServices() {
		return cartServices;
	}
	
	@Override
	public IEntityServices<CartItem> getCartItemServices() {
		return cartItemServices;
	}

	@Override
	public IEntityServices<Order> getOrderServices() {
		return orderServices;
	}

	@Override
	public IEntityServices<PurchaseStatus> getPurchaseStatusServices() {
		return purchaseStatusServices;
	}

	@Override
	public IEntityServices<DeliveryDetails> getDeliveryDetailsServices() {
		return deliveryDetailsServices;
	}
	
	@Override
	public IEntityServices<Etiqueta> getEtiquetaServices() {
		return etiquetaServices;
	}
	



	@Override
	public void setSessionContext(SessionContext sessionContext) {
		this.sessionContext = sessionContext;
	}
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public void setEncripter(IEncripter encripter) {
		this.encripter = encripter;
	}
	@Override
	public void setGrupoServices(IEntityServices<Grupo> grupoServices) {
		this.grupoServices = grupoServices;
	}
	@Override
	public void setUserServices(IEntityServices<User> userServices) {
		this.userServices = userServices;
	}
	@Override
	public void setProductServices(IEntityServices<Product> productServices) {
		this.productServices = productServices;
	}
	@Override
	public void setArticuloServices(IEntityServices<Articulo> articuloServices) {
		this.articuloServices = articuloServices;
	}
	@Override
	public void setOfertaServices(IEntityServices<Oferta> ofertaServices) {
		this.ofertaServices = ofertaServices;
	}
	@Override
	public void setCartServices(IEntityServices<Cart> cartServices) {
		this.cartServices = cartServices;
	}
	@Override
	public void setCartItemServices(IEntityServices<CartItem> cartItemServices) {
		this.cartItemServices = cartItemServices;
	}
	@Override
	public void setOrderServices(IEntityServices<Order> orderServices) {
		this.orderServices = orderServices;
	}
	@Override
	public void setPurchaseStatusServices(IEntityServices<PurchaseStatus> purchaseStatusServices) {
		this.purchaseStatusServices = purchaseStatusServices;
	}
	@Override
	public void setDeliveryDetailsServices(IEntityServices<DeliveryDetails> deliveryDetailsServices) {
		this.deliveryDetailsServices = deliveryDetailsServices;
	}
	@Override
	public void setEtiquetaServices(IEntityServices<Etiqueta> etiquetaServices) {
		this.etiquetaServices = etiquetaServices;
	}

	@Override
	public IEntityServices<?> getEntityServices(String entityClassName){
		IEntityServices<?> entityServices = null;
		switch(entityClassName) {
		case "Oferta":
			entityServices = getOfertaServices();
			break;
		case "Articulo":
			entityServices = getArticuloServices();
			break;
		case "Product":
			entityServices = getProductServices();
			break;
			default:				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ServiceLocator.getEntityService(nombreclase) - tipo desconocido = " + entityClassName));
			
		}		
		
		return entityServices;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
