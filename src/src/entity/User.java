package src.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.enterprise.context.Dependent;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
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
//	@NamedQuery(name="removeGrupo", query="DELETE FROM USER_GRUPO ug WHERE ug.NICK_USER LIKE :nick AND ug.NAME_GRUPO LIKE :grupo")

})
public class User implements Serializable, IPrototype<User>{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")	
	private Integer id;
	
	@NotNull
	@Column(name="NAME", nullable=false)	
	private String name;
	
	@NotNull
	@Column(name="NICK", unique=true, nullable=false)	
	private String nick;
	
	@NotNull
	@Column(name="EMAIL", nullable=false)	
	private String email;
	
	@NotNull
	@Column(name="PASS", nullable=false)	
	private String password;
	
	@NotNull
	@Column(name="ADDRESS", nullable=false)
	private String address;
	
	@NotNull
	@Column(name="TELEPHONE", nullable=false)
	private String telephone;
	
	@OneToMany(mappedBy="user", orphanRemoval = true, cascade={CascadeType.ALL})
	private List<UserProfile> profiles;

	
	

//	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
//	@JoinTable(name="USER_GRUPO",
//			joinColumns=@JoinColumn(name="NICK_USER", table="USERS", referencedColumnName="NICK"),
//			inverseJoinColumns=@JoinColumn(name="NAME_GRUPO", table="GRUPOS", referencedColumnName="NAME"))
//	private List<Grupo> listaGrupos;
	
	
	
	@Override
	public User clone(){
		User user = new User();
		user.setEmail(this.getEmail());
		user.setId(this.getId());
		user.setName(this.getName());
		user.setNick(this.getNick());
		user.setPassword(this.getPassword());
		user.setAddress(this.getAddress());
		user.setTelephone(this.getTelephone());
		
		user.setProfiles(this.getProfiles());
//		user.setListaGrupos(this.getListaGrupos());
		
		return user;
	}
	
	@Override
	public String toString(){
		String cadena = "";
		cadena = "User -   " + "id = " + getId() + 
				", name = " + getName() + 
				", nick = " + getNick() + 
				", address = " + getAddress() + 
				", email = " + getEmail() + 
				", telephone = " + getTelephone() + "\n";	
		
		for(UserProfile profile : getProfiles()) {
			cadena += profile.toString();
		}
		cadena += "\n";
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
	
	public void addProfile(UserProfile profile) {
		getProfiles().add(profile);
	}
	
	public void removeProfile(UserProfile profile) {
		getProfiles().remove(profile);
	}


	public void addGrupo(Grupo grupo){
		if(!grupoNuevo(grupo)) {return;}
		UserProfile profile = new UserProfile();
		
		profile.setFechaCreacion(new Date());
		profile.setGrupo(grupo);
		profile.setUser(this);
		
		addProfile(profile);
	}
	
	private boolean grupoNuevo(Grupo grupo) {
		boolean result = true;
		for(UserProfile profile : getProfiles()) {
			if(profile.getGrupo().getId().compareTo(grupo.getId()) == 0) {
				result = false;
			}
		}		
		return result;
	}
	
	public void removeGrupo(Grupo grupo){
		UserProfile selected = null;
		for(UserProfile profile : getProfiles()) {
			if(profile.getGrupo().getId().equals(grupo.getId())){
				selected = profile;
			}
		}	
		removeProfile(selected);
	}

	public List<UserProfile> getProfiles() {
		if(profiles == null) {
			profiles = new ArrayList<UserProfile>();
		}
		return profiles;
	}

	public void setProfiles(List<UserProfile> profiles) {
		this.profiles = profiles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
//	public List<Grupo> getListaGrupos() {
//	return listaGrupos;
//}
//
//public void setListaGrupos(List<Grupo> listaGrupos) {
//	this.listaGrupos = listaGrupos;
//}
	
	
}
