package src.entity;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.Dependent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import src.inter.IPrototype;

@Dependent
@Entity
@Table(name="USER_PROFILE")
public class UserProfile implements Serializable, IPrototype {
	

	private static final long serialVersionUID = 10101L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="USER_NICK", nullable=false, referencedColumnName="NICK")
	private User user;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="GRUPO_NAME", nullable=false, referencedColumnName="NAME")
	private Grupo grupo;
	
	@NotNull
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

	
	
	@Override
	public UserProfile clone() {
		UserProfile nuevo = new UserProfile();
		
		nuevo.setId(this.getId());
		nuevo.setFechaCreacion(this.getFechaCreacion());
		nuevo.setGrupo(this.getGrupo());
		nuevo.setUser(this.getUser());
		
		
		return nuevo;
	}
	
	@Override
	public String toString(){
		String cadena = "";
		cadena = "UserProfile - id = " + getId() + 
				", user = " + getUser().getId() + 
				", grupo = " + getGrupo().getId() + 
				", creacion = " + getFechaCreacion() + "\n";		
		return cadena;
	}
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fecha_creacion) {
		this.fechaCreacion = fecha_creacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
