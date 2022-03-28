package com.ddd.spring.application.client;

import com.ddd.spring.common.Command;
import com.ddd.spring.common.OneOf;
import com.ddd.spring.common.SelfValidating;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewClientForm extends SelfValidating<NewClientForm> implements Command {

	@NotNull(message = "O campo não pode ficar vazio!")
	@NotBlank(message = "O nome é obrigatório")
  @Length(min = 3, max = 35, message = "O nome deverá ter no máximo {max} caracteres")
  public String name;
	
	public String socialId;
	
	public String phone;

	@OneOf({ "Limpeza", "Alimentação" })
	public String type;

}
