package validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountryValid implements ConstraintValidator<AnotCountry, String> {

	@Override
	public void initialize(AnotCountry constraintAnnotation) {
		
		
	}

	@Override
	public boolean isValid(String country, ConstraintValidatorContext context) {
		
		if (country.matches("^//D{3-20}$")) {
			return true;
		} else {
			return false;
		}
	}

}
