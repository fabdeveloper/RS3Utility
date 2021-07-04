package src.entity;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.Dependent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import src.inter.IPrototype;

@Dependent
@Entity
@Table(name="DELIVERY_DETAILS")
public class DeliveryDetails implements Serializable, IPrototype<DeliveryDetails>{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@NotNull
	@Column(name="DELIVERY_ADDRESS", nullable=false)
	private String deliveryAddress;
		
	@Column(name="REMARKS")
	private String remark;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS", nullable=false, length=30)
	private DeliveryDetailsStatusType status;
	
	@NotNull
	@Column(name="LAST_MODIFICATION_DATE", nullable=false)
	private Date lastModificationDate;
	

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="DELIVERY_TYPE", nullable=false, length=30)
	private DeliveryType deliveryType;
	
	
	public DeliveryDetails clone(){
		DeliveryDetails nuevo = new DeliveryDetails();
		nuevo.setDeliveryAddress(this.getDeliveryAddress());
		nuevo.setId(this.getId());
//		nuevo.setOrder(this.getOrder());
		nuevo.setRemark(this.getRemark());	
		nuevo.setStatus(this.getStatus());
		nuevo.setLastModificationDate(this.getLastModificationDate());
		nuevo.setDeliveryType(this.getDeliveryType());		
		
		return nuevo;
	}
	
	@Override
	public String toString(){
//		super.toString();				
		String cadena = "DeliveryDetails -   " + "id = " + getId() + 
				", delivery address = " + getDeliveryAddress() + 
				", status = " + getStatus() + 
				", remarks = " + getRemark() + 
				", type = " + getDeliveryType() + 
				", modification = " + getLastModificationDate() + "\n";			
		return cadena;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}	

	public DeliveryDetailsStatusType getStatus() {
		return status;
	}

	public void setStatus(DeliveryDetailsStatusType status) {
		this.status = status;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public DeliveryType getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}

//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

}
