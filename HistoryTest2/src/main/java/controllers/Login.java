package controllers;




import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import daoImpl.DaoImplTest;
import daoImpl.DaoImplUser;
import model.LoginUser;
import model.Test;
import model.UserHib;


@Controller
@SessionAttributes(value = "userSession")
public class Login {

	@Autowired
	public SessionFactory sf;

	
	 public UserHib CheckUser(LoginUser loginUser) { 
		 DaoImplUser daoImplUser = new DaoImplUser(sf);
		 UserHib userHib = daoImplUser.getUserByNameAndPassword(loginUser.getName(),  loginUser.getPassword());
		 if (userHib!= null) 
		 { return userHib; 
		 }else { 
			 return null; 
			 
			 } 
		 }
	 
	@RequestMapping(value = "/goToLogin", method = RequestMethod.GET)
	public ModelAndView goToLogin() {
		
		return new ModelAndView("login","loginUser",new LoginUser());
	}
	@RequestMapping(value = "/startLogin",method = RequestMethod.POST)
	public ModelAndView startLogin(@Valid @ModelAttribute("loginUser")LoginUser loginUser,BindingResult br) {
		
		ModelAndView modelAndView = null;
		DaoImplUser daoImplUser = new DaoImplUser(sf);
		DaoImplTest daoImplTest = new DaoImplTest(sf);
		List<UserHib>users = new ArrayList<>();
		List<Test>tests = new ArrayList<>();
		
		if (br.hasErrors()) {
			return new ModelAndView("login","loginUser",new LoginUser());
		} else {
			UserHib userHib = CheckUser(loginUser);
			if (userHib ==null) {
				br.rejectValue("password", "error.LoginVoter", "An incorrect login or password");
			}
			if (br.hasErrors()) {
				return new ModelAndView("login","loginUser",new LoginUser());
			}
			if (userHib != null) {
				switch (userHib.getRole()) {
				case ("admin"):
					users = daoImplUser.getAllUser();
					modelAndView = new ModelAndView("admin");
					modelAndView.addObject("users",users);
					break;
				case ("master"):
					tests = daoImplTest.getAllTest();
					modelAndView = new ModelAndView("master");
					modelAndView.addObject("tests",tests);
					
					break;

				default:
					modelAndView = new ModelAndView("user");
					tests = daoImplTest.getAllTest();
					modelAndView.addObject("tests",tests);
					break;
				}
				modelAndView.addObject("userSession",userHib);
			}
			
			return modelAndView;
		}
		
		
	}
}
