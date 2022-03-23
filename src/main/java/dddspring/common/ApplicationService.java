package dddspring.common;

import org.springframework.http.ResponseEntity;

public abstract class ApplicationService {

	public abstract ResponseEntity<Object> process(Command command);
}
