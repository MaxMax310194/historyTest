package controllers;

import javax.validation.Valid;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import daoImpl.DaoImplUser;
import model.Detail;
import model.LoginUser;
import model.RegUser;
import model.UserHib;

@Controller
public class RegistrationUser {

	@Autowired
	SessionFactory sf;
	
	public void regUserFull(RegUser regUser,UserHib userHib) {
		DaoImplUser daoImplUser = new DaoImplUser(sf);
		Detail detail;
		detail = new Detail(regUser.getCountry(),regUser.getAge());
		userHib = new UserHib(regUser.getName(), regUser.getPassword(), regUser.getEmail(), "user", detail);
		detail.setUser(userHib);
		daoImplUser.addUser(userHib);
	}
	
	@RequestMapping(value = "/goToReg",method = RequestMethod.GET)
	public ModelAndView goToReg() {
		
		return new ModelAndView("registration","regUser", new RegUser());
	}
	
	@RequestMapping(value = "/regController", method = RequestMethod.POST)
	public ModelAndView  regController(@Valid @ModelAttribute("regUser")RegUser regUser, BindingResult br) {
		
		ModelAndView modelAndView;
		DaoImplUser daoImplUser = new DaoImplUser(sf);
		UserHib userHib = daoImplUser.getUserByName(regUser.getName());
		
		if (userHib!=null) {
			br.rejectValue("name", "error.RegistrationVoter", "An account already exists for this name");
				return new ModelAndView("registration","regUser", regUser);
		}else if (br.hasErrors()) {
			return new ModelAndView("registration","regUser", regUser);
		}else {
			if (regUser.getAge().equals("") && regUser.getCountry().equals("")) {
				userHib = new UserHib(regUser.getName(), regUser.getPassword(), regUser.getEmail(), "user");
				daoImplUser.addUser(userHib);
			}else {
				regUserFull(regUser, userHib);
			}
			modelAndView = new ModelAndView("login","loginUser", new LoginUser());
		
			modelAndView.addObject("regUse",regUser);
			
		}
		
		
		return modelAndView;
	}
	
}
