package dddspring.application.client;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/rest/clients")
public class RestControllerClient {
	
	@GetMapping
	public List<ProjectionClient> list() {
		
		List<ProjectionClient> list = new ArrayList<>();
		
		ProjectionClient client1 = new ProjectionClient();
		client1.id = "1";
		client1.name = "João Cana Brava";
		client1.socialId = "714.626.545-85";
		client1.phone = "(67)-98568-4574";
		list.add(client1);

		ProjectionClient client2 = new ProjectionClient();
		client2.id = "2";
		client2.name = "Mathias Perez";
		client2.socialId = "075.254.265-99 ";
		client2.phone = "(11)-99585-1457";
		list.add(client2);

		ProjectionClient client3 = new ProjectionClient();
		client3.id = "3";
		client3.name = "Jonas Eisenhard";
		client3.socialId = "079.584.540-56";
		client3.phone = "(67)-98568-4574";
		list.add(client3);

		ProjectionClient client4 = new ProjectionClient();
		client4.id = "4";
		client4.name = "Joana da Silva";
		client4.socialId = "185.881.236-54 ";
		client4.phone = "(67)-98568-4574";
		list.add(client4);
		
		return list;
	}

	@PostMapping
	public ResponseEntity<Object> save(@Valid @RequestBody NewClientCommand command) {
		return ResponseEntity.ok("User is valid");
	}
}
