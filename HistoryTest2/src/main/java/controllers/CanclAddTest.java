package controllers;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import daoImpl.DaoImplTest;
import model.Test;
import model.UserHib;

@Controller
public class CanclAddTest {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value = "/canslAddTest",method = RequestMethod.POST)
	public ModelAndView name(@SessionAttribute("userSession")UserHib userSession) {
		ModelAndView modelAndView = new ModelAndView("master");
		DaoImplTest daoImplTest = new DaoImplTest(sf);
		List<Test>tests = daoImplTest.getAllTest();
		modelAndView.addObject("tests",tests);
		modelAndView.addObject("userSession",userSession);
		
		return modelAndView;
	}
	
}
