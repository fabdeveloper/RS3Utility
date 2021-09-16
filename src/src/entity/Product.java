package src.entity;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import src.inter.IPrototype;

@Dependent
@Entity
@Table(name="PRODUCTS")
@NamedQueries({
	@NamedQuery(name="productById", query="SELECT b FROM Product b WHERE b.id = :product_id"),
	@NamedQuery(name="productByName", query="SELECT b FROM Product b WHERE b.name LIKE :product_name"),
	@NamedQuery(name="productsByType", query="SELECT b FROM Product b WHERE b.type LIKE :type")}	
	)
public class Product implements Serializable, IPrototype<Product>{
	

	private static final long serialVersionUID = 120L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID")
	@OneToMany(mappedBy="product")
	private Integer id;
	
	@NotNull
	@Column(name="NAME", unique=true, nullable=false)
	private String name;
	
	@NotNull
	@Column(name="TYPE", nullable=false)
	private String type;
	
	@Column(name="URL_IMAGE")
	private String urlImage;


	
	/***************************************/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*******************************************/

	@Override
	public Product clone(){
		
		Product nuevo = new Product();
		nuevo.setId(this.getId());
		nuevo.setName(this.getName());
		nuevo.setType(this.getType());
		
		return nuevo;
		
	}
	
	
	@Override
	public String toString() {
		String sResult = super.toString() + "\n";
		
		sResult += "Product -> " + "\n" +
							"id= " + this.getId()  + "\n" +
							"name= " + this.getName()  + "\n" +
							"type= " + this.getType()  + "\n" +
							"urlImage= " + this.getUrlImage()  + "\n";		
		
		return sResult;
	}


	
	
	

}
