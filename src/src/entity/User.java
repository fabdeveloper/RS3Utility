package src.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import src.inter.IUser;
import src.inter.IPrototype;

@Dependent
@Entity
@Table(name="USERS")
@NamedQueries({
	@NamedQuery(name="byName", query="SELECT u FROM User u WHERE u.name LIKE :nombre"),
	@NamedQuery(name="byEmail", query="SELECT u FROM User u WHERE u.email LIKE :email"),
	@NamedQuery(name="byNick", query="SELECT u FROM User u WHERE u.nick LIKE :nick")

})
public class User implements Serializable, IPrototype<User>{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")	
	private Integer id;
	
	@NotNull
	@Column(name="NAME")	
	private String name;
	
	@NotNull
	@Column(name="NICK", unique=true)	
	private String nick;
	
	@NotNull
	@Column(name="EMAIL")	
	private String email;
	
	@NotNull
	@Column(name="PASS")	
	private String password;
	
	@NotNull
	@Column(name="ADDRESS")
	private String address;
	
	@NotNull
	@Column(name="TELEPHONE")
	private String telephone;

	@ManyToMany
	@JoinTable(name="USER_GRUPO",
			joinColumns=@JoinColumn(name="NICK_USER", table="USERS", referencedColumnName="NICK"),
			inverseJoinColumns=@JoinColumn(name="NAME_GRUPO", table="GRUPOS", referencedColumnName="NAME"))
	private List<Grupo> listaGrupos;
	
	
	
	@Override
	public User clone(){
		User user = new User();
		user.setEmail(this.getEmail());
		user.setId(this.getId());
		user.setName(this.getName());
		user.setNick(this.getNick());
		user.setPassword(this.getPassword());
		user.setTelephone(this.getTelephone());
		user.setListaGrupos(this.getListaGrupos());
		
		return user;
	}
	
	public String toString(){
		super.toString();
		
		String cadena = "";
		cadena = "User -   " + "id = " + getId() + ", name = " + getName() + 
				", nick = " + getNick() + ", address = " + getAddress() + ", email = " + getEmail() + "\n";
		
		
		return cadena;
	}
	

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
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Grupo> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<Grupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public void addGrupo(Grupo grupo){
		if(getListaGrupos() == null){
			setListaGrupos(new ArrayList<Grupo>());
		}
		this.listaGrupos.add(grupo);
	}
	
	public void removeGrupo(Grupo grupo){
		this.listaGrupos.remove(grupo);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
