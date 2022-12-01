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
import daoImpl.DaoImplTest;
import model.RegTest;
import model.Test;
import model.UserHib;

@Controller
public class AddTest {

	@Autowired
	 SessionFactory sf;
	
	@RequestMapping(value = "/addTest",method = RequestMethod.POST)
	public ModelAndView addTest(@ModelAttribute("regTest")RegTest regTest,@SessionAttribute("userSession")UserHib userSession) {
		
		ModelAndView modelAndView = new ModelAndView("master");
		DaoImplTest daoImplTest = new DaoImplTest(sf);
		
		Test test = new Test(regTest.getQuestion(), regTest.getAnswer1(), regTest.getAnswer2(), regTest.getAnswer3(), regTest.getAnswer4(), regTest.getAnswer5(),regTest.getCorrectAnswer());
		daoImplTest.addTest(test);
		List<Test>tests = daoImplTest.getAllTest();
		modelAndView.addObject("tests",tests);
		modelAndView.addObject("userSession",userSession);
		
		
		
		return modelAndView;
	}
}
