package controllers;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import daoImpl.DaoImplUser;
import model.RegUser;
import model.UserHib;

@Controller
public class UpdateUser {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value = "/updateUser",method = RequestMethod.POST)
	public ModelAndView updateUser(@SessionAttribute("userSession")UserHib userSession,@ModelAttribute("regUser")RegUser regUser) {
		
		ModelAndView modelAndView =  new ModelAndView("user");
		DaoImplUser daoImplUser = new DaoImplUser(sf);
		
			if (!regUser.getName().equals("")) {
				userSession.setName(regUser.getName());
			}
			if (!regUser.getPassword().equals("")) {
				userSession.setPassword(regUser.getPassword());
			}if (!regUser.getEmail().equals("")) {
				userSession.setEmail(regUser.getEmail());
			}
		if (userSession.getDetail()!=null) {
			userSession.getDetail().setCountry(regUser.getCountry());
			userSession.getDetail().setAge(regUser.getAge());
		}
		
		daoImplUser.upUser(userSession);
		List<UserHib>users = daoImplUser.getAllUser();
		modelAndView.addObject("users",users);
		modelAndView.addObject("userSession",userSession);
		
		return modelAndView;
	}
	
}
