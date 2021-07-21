package src.inter;

import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import src.entity.Articulo;
import src.entity.Cart;
import src.entity.CartItem;
import src.entity.DeliveryDetails;
import src.entity.Grupo;
import src.entity.Oferta;
import src.entity.Order;
import src.entity.Product;
import src.entity.PurchaseStatus;
import src.entity.User;
import src.entityservices.IEntityServices;
import src.entity.Etiqueta;

public interface IServiceLocator {
	
	public SessionContext getSessionContext();
	
	public EntityManager getEntityManager();
	
	public IEncripter getEncripter();
	
	public IEntityServices<Grupo> getGrupoServices();
	
	public IEntityServices<User> getUserServices();
	
	public IEntityServices<Product> getProductServices();

	public IEntityServices<Articulo> getArticuloServices();

	public IEntityServices<Oferta> getOfertaServices();
	
	public IEntityServices<Cart> getCartServices();
	
	public IEntityServices<CartItem> getCartItemServices();
	
	public IEntityServices<Order> getOrderServices();

	public IEntityServices<PurchaseStatus> getPurchaseStatusServices();

	public IEntityServices<DeliveryDetails> getDeliveryDetailsServices();
	
	public IEntityServices<Etiqueta> getEtiquetaServices();
	
	public IEntityServices<?> getEntityServices(String entityClassName);
	




	public void setSessionContext(SessionContext sessionContext);
	public void setEntityManager(EntityManager entityManager);
	public void setEncripter(IEncripter encripter);
	public void setGrupoServices(IEntityServices<Grupo> grupoServices);
	public void setUserServices(IEntityServices<User> userServices);
	public void setProductServices(IEntityServices<Product> productServices);
	public void setArticuloServices(IEntityServices<Articulo> articuloServices);
	public void setOfertaServices(IEntityServices<Oferta> ofertaServices);
	public void setCartServices(IEntityServices<Cart> cartServices);
	public void setCartItemServices(IEntityServices<CartItem> cartItemServices);
	public void setOrderServices(IEntityServices<Order> orderServices);
	public void setPurchaseStatusServices(IEntityServices<PurchaseStatus> purchaseStatusServices);
	public void setDeliveryDetailsServices(IEntityServices<DeliveryDetails> deliveryDetailsServices);
	public void setEtiquetaServices(IEntityServices<Etiqueta> etiquetaServices);
	

}
