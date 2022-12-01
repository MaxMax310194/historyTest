package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserHib {

	@Id
	@GeneratedValue
	@Column(name = "idUser")
	private int idUser;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "role")
	private String role;
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private Detail detail;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Detail getDetail() {
		return detail;
	}
	public void setDetail(Detail detail) {
		this.detail = detail;
	}
	public UserHib(int idUser, String name, String password, String email, String role, Detail detail) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
		this.detail = detail;
	}
	public UserHib(String name, String password, String email, String role, Detail detail) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
		this.detail = detail;
	}
	public UserHib(String name, String password, String email, String role) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	
	public UserHib() {
		super();
	}
	
	
	
	
	
	
}
