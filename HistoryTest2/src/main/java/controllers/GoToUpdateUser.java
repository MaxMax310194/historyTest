package controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import model.RegUser;
import model.UserHib;

@Controller
public class GoToUpdateUser {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value = "/goToUpUser",method = RequestMethod.POST)
	public ModelAndView goToUpUser(@ModelAttribute("regUser")RegUser regUser,@SessionAttribute("userSession")UserHib userSession) {
		
		ModelAndView modelAndView = new ModelAndView("upUser");
		
		if (userSession.getDetail().equals(null)) {
			modelAndView.addObject("regUser",new RegUser(userSession.getName(), userSession.getPassword(), userSession.getEmail()));
		}else {
			modelAndView.addObject("regUser", new RegUser(userSession.getName(), userSession.getPassword(), userSession.getEmail(), userSession.getDetail().getCountry(),
					userSession.getDetail().getAge()));
			
		}
		
		return modelAndView;
	}
}
