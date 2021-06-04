package src.entity;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;

import src.inter.IPrototype;

@RequestScoped
@Entity
@Table(name="GRUPOS")
@NamedQueries({
	@NamedQuery(name="grupo_byName", query="SELECT g FROM Grupo g WHERE g.name LIKE :name")
})
public class Grupo implements Serializable, IPrototype<Grupo>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME", unique=true)
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	
//	@ManyToOne
//	@JoinColumn(name="FK_STORE")
//	private Store store;
	
	@Override
	public Grupo clone(){
		
		Grupo nuevo = new Grupo();
		nuevo.setId(this.getId());
		nuevo.setName(this.getName());
		nuevo.setDescription(this.getDescription());
//		nuevo.setStore(this.getStore());

		return nuevo;		
	}
	
	/******************************************************/
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
