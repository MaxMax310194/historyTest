package controllers;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import daoImpl.DaoImplTest;
import model.RegTest;
import model.Test;

@Controller
@SessionAttributes(value = {"updateTest"})
public class GoToUpdateTest {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value = "/goToUpTest",method = RequestMethod.POST)
	public ModelAndView updateTest(@RequestParam Map<String, String>params) {
		
		ModelAndView modelAndView = new ModelAndView("upTest");
		DaoImplTest daoImplTest = new DaoImplTest(sf);
		List<Test>tests = daoImplTest.getAllTest();
		for (int i = 0; i < tests.size(); i++) {
			if (params.get("u"+tests.get(i).getIdTest())!= null) {
			modelAndView.addObject("regTest",new RegTest(tests.get(i).getQuestion(), tests.get(i).getAnswer1(), tests.get(i).getAnswer2(), tests.get(i).getAnswer3(), 
					tests.get(i).getAnswer4(), tests.get(i).getAnswer5(), tests.get(i).getCorrectAnswer()));
			modelAndView.addObject("updateTest",tests.get(i));
			}
		}
		
		return modelAndView;
	}
}
