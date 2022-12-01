package dao;


import java.util.List;

import model.UserHib;

public interface daoUser {

	public List<UserHib> getAllUser(); 
	public void addUser(UserHib user);
	public void delUser(UserHib user);
	public void upUser(UserHib user);
	public UserHib getUserByName(String name);
	public UserHib getUserByNameAndPassword(String name,String password);
		

		
	
		
	
	
	
}
