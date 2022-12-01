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
public class UpdateTest {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value = "/updateTest",method = RequestMethod.POST)
	public ModelAndView updateTest(@SessionAttribute("userSession")UserHib userSession,@ModelAttribute("regTest")RegTest regTest,@SessionAttribute("updateTest")Test updateTest) {
		
		ModelAndView modelAndView = new ModelAndView("master");
		DaoImplTest daoImplTest = new DaoImplTest(sf);
		if (!regTest.getQuestion().equals("")) {
			updateTest.setQuestion(regTest.getQuestion());
		}
		if (!regTest.getAnswer1().equals("")) {
			updateTest.setAnswer1(regTest.getAnswer1());
		}
		if (!regTest.getAnswer2().equals("")) {
			updateTest.setAnswer2(regTest.getAnswer2());
		}
		if (!regTest.getAnswer3().equals("")) {
			updateTest.setAnswer3(regTest.getAnswer3());
		}
		if (!regTest.getAnswer4().equals("")) {
			updateTest.setAnswer4(regTest.getAnswer4());
		}
		if (!regTest.getAnswer5().equals("")) {
			updateTest.setAnswer5(regTest.getAnswer5());
		}
		if (!regTest.getCorrectAnswer().equals("")) {
			updateTest.setCorrectAnswer(regTest.getCorrectAnswer());
		}
		
		daoImplTest.upTest(updateTest);
		List<Test>tests = daoImplTest.getAllTest();
		modelAndView.addObject("userSession",userSession);
		modelAndView.addObject("tests",tests);
		
		
		return modelAndView;
		
	}
}
