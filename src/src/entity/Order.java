package src.entity;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.Dependent;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import src.inter.IPrototype;

@Dependent
@Entity
@Table(name="ORDERS")
@NamedQueries({
//	@NamedQuery(name="loadPendingOrder", query = "SELECT o FROM Order o WHERE o.purchaseStatus.status NOT IN (src.entity.PurchaseStatusType.CONFIRMADO, src.entity.PurchaseStatusType.CANCELADO, src.entity.PurchaseStatusType.PRE_CONFIRMADO, src.entity.PurchaseStatusType.PAYMENT_ERROR) AND o.client.nick LIKE :client_nick"),
	@NamedQuery(name="loadPendingOrder", query = "SELECT o FROM Order o WHERE o.purchaseStatus.status = src.entity.PurchaseStatusType.NO_CONFIRMADO AND o.client.nick LIKE :client_nick"),
	@NamedQuery(name="ordersAll", query="SELECT b FROM Order b ORDER BY b.id DESC"),
	@NamedQuery(name="ordersAllByClient", query="SELECT b FROM Order b WHERE b.client.nick LIKE :client_nick ORDER BY b.confirmationDate DESC"),
	@NamedQuery(name="loadPendingDeliveryOrders", query = "SELECT o FROM Order o WHERE o.purchaseStatus.status = src.entity.PurchaseStatusType.CONFIRMADO AND o.deliveryDetails.status != src.entity.DeliveryDetailsStatusType.ENTREGADO"),
	@NamedQuery(name="allPreConfirmedOrdersUntil", query = "SELECT o FROM Order o WHERE o.purchaseStatus.status = src.entity.PurchaseStatusType.PRE_CONFIRMADO AND o.purchaseStatus.lastModification < :limit_date")
})
public class Order implements Serializable, IPrototype<Order>{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@NotNull
	@JoinColumn(name="CLIENT_ID", nullable=false)
	@ManyToOne(optional=false)
	private User client;
	
	@NotNull
	@JoinColumn(name="CART_ID", nullable=false)
	@OneToOne(optional=false, cascade={CascadeType.ALL})
	private Cart cart;
	
	
	@NotNull
	@JoinColumn(name="PURCHASESTATUS_ID", nullable=false)
	@OneToOne(cascade=CascadeType.ALL)
	private PurchaseStatus purchaseStatus;
	
	@NotNull
	@JoinColumn(name="DELIVERYDETAILS_ID", nullable=false)
	@OneToOne(cascade=CascadeType.ALL)
	private DeliveryDetails deliveryDetails;
	
	
	@NotNull
	@Column(name="LAST_MODIFICATION_DATE", nullable=false)
	private Date lastModificationDate;
	
	@NotNull
	@Column(name="CREATION_DATE", nullable=false)
	private Date creationDate;	
	
	
	@Column(name="CONFIRMATION_DATE")
	private Date confirmationDate;


	
	
	public Order clone(){
		Order nuevo = new Order();
		nuevo.setCart(this.getCart());
		nuevo.setClient(this.getClient());
		nuevo.setConfirmationDate(this.getConfirmationDate());
		nuevo.setLastModificationDate(this.getLastModificationDate());
		nuevo.setCreationDate(this.getCreationDate());
		nuevo.setDeliveryDetails(this.getDeliveryDetails());
		nuevo.setId(this.getId());
		nuevo.setPurchaseStatus(this.getPurchaseStatus());
		
		return nuevo;		
	}
	
	@Override
	public String toString(){
//		super.toString();		
		String cadena = "Order -   " + "id = " + getId() + 
				", creation = " + getCreationDate() + 
				", modification = " + getLastModificationDate() + 
				", confirmation = " + getConfirmationDate() + "\n" +
				", client = " + getClient().toString() + 
				", cart = " + getCart().toString() + 
				", deliverydetails = " + getDeliveryDetails().toString() + 
				", purchasestatus = " + getPurchaseStatus().toString();		
		return cadena;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Date getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public PurchaseStatus getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public DeliveryDetails getDeliveryDetails() {
		return deliveryDetails;
	}

	public void setDeliveryDetails(DeliveryDetails deliveryDetails) {
		this.deliveryDetails = deliveryDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

}
