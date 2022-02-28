package dddspring.application;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRest {
	
	@GetMapping("/rest/clients")
	public List<ClientDto> list() {
		
		List<ClientDto> list = new ArrayList<ClientDto>();
		
		ClientDto client1 = new ClientDto();
		client1.id = "1";
		client1.name = "João Cana Brava";
		client1.cpf = "714.626.545-85";
		client1.fone = "(67)-98568-4574";
		list.add(client1);
		
		ClientDto client2 = new ClientDto();
		client2.id = "2";
		client2.name = "Mathias Perez";
		client2.cpf = "075.254.265-99 ";
		client2.fone = "(11)-99585-1457";
		list.add(client2);
		
		ClientDto client3 = new ClientDto();
		client3.id = "3";
		client3.name = "Jonas Eisenhard";
		client3.cpf = "079.584.540-56";
		client3.fone = "(67)-98568-4574";
		list.add(client3);
		
		ClientDto client4 = new ClientDto();
		client4.id = "4";
		client4.name = "Joana da Silva";
		client4.cpf = "185.881.236-54 ";
		client4.fone = "(67)-98568-4574";
		list.add(client4);
		
		return list;
	}
	
}
