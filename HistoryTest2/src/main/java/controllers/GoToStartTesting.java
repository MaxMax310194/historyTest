package controllers;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import daoImpl.DaoImplTest;
import model.Test;



@Controller
@SessionAttributes( value = {"numberTest","sessionTests"})
public class GoToStartTesting {

	
	@Autowired
	SessionFactory sf;
	
	@RequestMapping (value = "/goToStartTesting",method = RequestMethod.POST)
	public ModelAndView GoStartTesting() {
		
		DaoImplTest daoImplTest = new DaoImplTest(sf);
		List<Test>tests = daoImplTest.getAllTest();
		int numberTest = 0;
		String question = tests.get(numberTest).getQuestion();
		String answer1 = tests.get(numberTest).getAnswer1();
		String answer2 = tests.get(numberTest).getAnswer2();
		String answer3 = tests.get(numberTest).getAnswer3();
		String answer4 = tests.get(numberTest).getAnswer4();
		String answer5 = tests.get(numberTest).getAnswer5();
		ModelAndView modelAndView = new ModelAndView("startTest"); 
		modelAndView.addObject("sessionTests",tests);
		modelAndView.addObject("numberTest",numberTest);
		modelAndView.addObject("question",question);
		modelAndView.addObject("answer1",answer1);
		modelAndView.addObject("answer2",answer2);
		modelAndView.addObject("answer3",answer3);
		modelAndView.addObject("answer4",answer4);
		modelAndView.addObject("answer5",answer5);
	
		return modelAndView;
	}
}
