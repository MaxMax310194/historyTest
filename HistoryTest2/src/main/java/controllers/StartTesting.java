package controllers;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import model.Test;


@Controller
public class StartTesting {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping (value = "/nextTetest",method = RequestMethod.POST)
	public ModelAndView goTesting(@SessionAttribute("numberTest")int numberTest ,@SessionAttribute("sessionTests")List<Test>tests) {
		
		System.out.println(numberTest);
		ModelAndView modelAndView = null;
	
			
		if (numberTest <tests.size()-1) {
			numberTest++;
		
		System.out.println(numberTest);
		modelAndView = new ModelAndView("startTest");
		String answer1 = tests.get(numberTest).getAnswer1();
		String answer2 = tests.get(numberTest).getAnswer2();
		String answer3 = tests.get(numberTest).getAnswer3();
		String answer4 = tests.get(numberTest).getAnswer4();
		String answer5 = tests.get(numberTest).getAnswer5();
		String question = tests.get(numberTest).getQuestion();
		modelAndView.addObject("numberTest",numberTest);
		modelAndView.addObject("question",question);
		modelAndView.addObject("answer1",answer1);
		modelAndView.addObject("answer2",answer2);
		modelAndView.addObject("answer3",answer3);
		modelAndView.addObject("answer4",answer4);
		modelAndView.addObject("answer5",answer5);

	
		}else  {
			
			modelAndView = new ModelAndView("finishTest");
		
		};
		
		
		return modelAndView;
	}
	
}
