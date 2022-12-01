package controllers;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import daoImpl.DaoImplUser;
import model.UserHib;

@Controller
public class CancelAddUser {

	@Autowired
	public SessionFactory sf;
	
	@RequestMapping(value = "/canselAddUser",method = RequestMethod.POST)
	public ModelAndView canselAddUser(@SessionAttribute("userSession")UserHib userSession) {
		
		ModelAndView modelAndView = new ModelAndView("admin");
		DaoImplUser daoImplUser = new DaoImplUser(sf);
		List<UserHib>users = daoImplUser.getAllUser();
		modelAndView.addObject("users",users);
		modelAndView.addObject("userSession",userSession);
		
		return modelAndView;
		
	}
	

}
