package controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.RegUser;

@Controller
public class GoToAddUser {
	
	@Autowired
	public SessionFactory sf;
	
	
	@RequestMapping(value = "/goToAddUser",method = RequestMethod.POST)
	public ModelAndView goToAddUser(@ModelAttribute("regUser")RegUser regUser) {
		
		ModelAndView modelAndView = new ModelAndView("addUser");
		
		return modelAndView;
		
	}

}
