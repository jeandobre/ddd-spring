package dddspring.application.client;

import dddspring.common.Command;
import dddspring.common.OneOf;
import dddspring.common.SelfValidating;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewClientCommand extends SelfValidating<NewClientCommand> implements Command {

	@NotNull(message = "O campo não pode ficar vazio!")
	@NotBlank(message = "O nome é obrigatório")
  @Length(min = 3, max = 35, message = "O nome deverá ter no máximo {max} caracteres")
  public String name;
	
	public String socialId;
	
	public String phone;

	//@OneOf({ "Limpeza", "Alimentação" })
	public String type;

}