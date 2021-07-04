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
@Table(name="PURCHASE_STATUS")
public class PurchaseStatus implements Serializable, IPrototype<PurchaseStatus>{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	
	@Column(name="REMARKS")
	private String remark;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS", nullable=false, length=30)
	private PurchaseStatusType status;

	
	@NotNull
	@Column(name="MODIFICATION_DATE", nullable=false)
	private Date lastModification;
	
	
	public PurchaseStatus clone(){
		PurchaseStatus nuevo = new PurchaseStatus();
		nuevo.setId(this.getId());
		nuevo.setLastModification(this.getLastModification());
		nuevo.setRemark(this.getRemark());
		nuevo.setStatus(this.getStatus());		
		
		return nuevo;		
	}
	
	@Override
	public String toString(){
//		super.toString();				
		String cadena = "PurchaseStatus -   " + "id = " + getId() + 
				", modificado = " + getLastModification() + 
				", status = " + getStatus() + 
				", remarks = " + getRemark() + "\n";			
		return cadena;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Date getLastModification() {
		return lastModification;
	}

	public void setLastModification(Date lastModification) {
		this.lastModification = lastModification;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PurchaseStatusType getStatus() {
		return status;
	}

	public void setStatus(PurchaseStatusType status) {
		this.status = status;
	}
	
	
	

}
