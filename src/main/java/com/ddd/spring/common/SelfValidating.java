package com.ddd.spring.common;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;

/*
	Validações mais comuns

	@NotNull -> Válida se o campo está nulo.
	@NotEmpty -> Válida se o campo está vazio.
	@NotBlank -> Válida se o campo está nulo ou vazio.
	@Past -> Válida se a data é hoje ou qualquer dia antes de hoje.
	@Future -> Válida se a data é hoje ou qualquer dia depois de hoje.
	@Length -> Válida o tamanho mínimo e máximo de um campo.
	@Max -> Válida o tamanho máximo de um campo.
	@Min -> Valida o tamanho mínimo de um campo.
*/
public abstract class SelfValidating<T extends Command> {

	private Validator validator;
	private Boolean valid;

	public SelfValidating() {
		this.valid = Boolean.FALSE;
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	protected void validate() {
		Set<ConstraintViolation<T>> violations = validator.validate((T) this);
		if(!violations.isEmpty()) {
			String errorMessage = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", "));
			System.out.println(errorMessage);
		}
	}

	public Boolean isValid() {
		return this.valid;
	}
}
