package model;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginUser {

	@NotEmpty
	public String name;
	@NotEmpty
	public String password;
	
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
	public LoginUser() {
		super();
	}
	public LoginUser(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	
	
}
