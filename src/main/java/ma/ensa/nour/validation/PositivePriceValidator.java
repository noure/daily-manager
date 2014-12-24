package ma.ensa.nour.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class PositivePriceValidator implements
ConstraintValidator<PositivePrice, Double>{

	@Override
	public void initialize(PositivePrice constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		return value>=0;
	}

	
	
	
}
