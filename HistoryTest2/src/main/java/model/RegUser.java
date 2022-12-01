package model;



import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RegUser {

	@NotEmpty
	@Size(min = 5)
	private String name;
	@NotEmpty
	@Size(min = 5)
	private String password;
	@NotEmpty
	@Email
	private String email;
	private String country;
	private String age;
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
	public RegUser() {
		super();
	}
	public RegUser(String name, String password, String email, String country, String age) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.country = country;
		this.age = age;
	}
	public RegUser(String name, String password, String email, String country) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.country = country;
	}
	public RegUser(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}


	
	
	
	
	 
}
