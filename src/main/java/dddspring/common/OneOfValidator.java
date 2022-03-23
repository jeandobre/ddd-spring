package dddspring.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * @author jeandobre
 */
public class OneOfValidator implements ConstraintValidator<OneOf, String> {

	private String[] values;

	@Override
	public void initialize(OneOf annotation) {
		this.values = annotation.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) return true;

		return Arrays.asList(values).contains(value);
	}
}
