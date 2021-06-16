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

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import src.inter.IPrototype;

@Dependent
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
	
	@NotNull
	@Column(name="NAME", unique=true, nullable=false)
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	

	
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
