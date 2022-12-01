package controllers;



import java.util.List;

import javax.validation.Valid;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import daoImpl.DaoImplUser;
import model.Detail;
import model.RegUser;
import model.UserHib;

@Controller
public class AddUserWithAdmin {

	@Autowired
	public SessionFactory sf;
	
	@RequestMapping(value = "/addUserWithAdmin",method = RequestMethod.POST)
	public ModelAndView addUserWithAdmin(@Valid @ModelAttribute("regUser")RegUser regUser,@SessionAttribute("userSession")UserHib userSession,BindingResult br) {
	
		ModelAndView modelAndView = null;
		DaoImplUser daoImplUser = new DaoImplUser(sf);
		UserHib userHib = daoImplUser.getUserByName(regUser.getName());
		
		if (userHib!=null) {
			br.rejectValue("name", "error.RegistrationVoter", "An account already exists for this name");
			return modelAndView = new ModelAndView("addUser");
		}else if (br.hasErrors()) {
			return modelAndView = new ModelAndView("addUser");
		}else {
			if (!regUser.getCountry().equals("") && !regUser.getAge().equals("")) {
				Detail detail = new Detail(regUser.getCountry(),regUser.getAge());
				userHib = new UserHib(regUser.getName(), regUser.getPassword(), regUser.getEmail(), "user", detail);
				detail.setUser(userHib);
				daoImplUser.addUser(userHib);
				
			}else {
				userHib = new UserHib(regUser.getName(), regUser.getPassword(), regUser.getEmail(), "user");
				daoImplUser.addUser(userHib);
			}
			
		}
		modelAndView = new ModelAndView("admin");
		List<UserHib>users = daoImplUser.getAllUser();
		modelAndView.addObject("users",users);
		modelAndView.addObject("userSession",userSession);
		
		return modelAndView;
		
	}
}
