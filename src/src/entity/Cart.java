package src.entity;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import src.inter.IPrototype;

@Dependent
@Entity
@Table(name="CARTS")
public class Cart implements Serializable, IPrototype<Cart>{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	
	@OneToMany(mappedBy="cart", orphanRemoval = true, cascade={CascadeType.ALL})
	private List<CartItem> listaItems;
	
	@NotNull
	@Column(name="VALUE", nullable=false)
	private Float value;
	
	

	public Cart clone(){
		Cart nuevo = new Cart();
		nuevo.setId(this.getId());
		nuevo.setValue(this.getValue());
		nuevo.setListaItems(this.getListaItems());
		
		return nuevo;
	}
	
	public String toString(){
//		super.toString();		
		String cadena = "Cart -   " + " id = " + getId() + 
				", value = " + getValue() + 
				", listaItems = " + "\n";
		for(CartItem item : getListaItems()){ cadena += item.toString();}
		cadena += "\n";
		return cadena;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<CartItem> getListaItems() {
		return listaItems;
	}

	public void setListaItems(List<CartItem> listaItems) {
		this.listaItems = listaItems;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
