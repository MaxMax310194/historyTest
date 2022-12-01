package validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import model.UserHib;

public class AgeValid implements ConstraintValidator<AnotAge, String>{

	@Override
	public void initialize(AnotAge constraintAnnotation) {
		
		
	}

	@Override
	public boolean isValid(String age, ConstraintValidatorContext contextValid) {
		// TODO Auto-generated method stub
		UserHib userHib = null;
		if (!userHib.getDetail().getAge().equals(null)) {
			age.matches("^//d{1,2}$");
			return true;
		}else {
			return false;
		}
		
		
	}

	
}
