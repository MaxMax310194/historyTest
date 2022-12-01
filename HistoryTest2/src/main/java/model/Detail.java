package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "detail")
public class Detail {
	
	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy=("foreign"),parameters=@Parameter(name="property",value="user"))
	@Column(name = "idUser")
	private int idUser;
	@Column(name = "country")
	private String country;
	@Column(name = "age")
	private String age;
	@OneToOne
	@PrimaryKeyJoinColumn
	private UserHib user;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public UserHib getUser() {
		return user;
	}
	public void setUser(UserHib user) {
		this.user = user;
	}
	public Detail(int idUser, String country, String age, UserHib user) {
		super();
		this.idUser = idUser;
		this.country = country;
		this.age = age;
		this.user = user;
	}
	public Detail(String country, String age, UserHib user) {
		super();
		this.country = country;
		this.age = age;
		this.user = user;
	}
	public Detail(String country, String age) {
		super();
		this.country = country;
		this.age = age;
	}
	public Detail() {
		super();
	}
//	
	

}
