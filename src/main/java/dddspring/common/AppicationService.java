package dddspring.common;

import com.ddd.spring.common.Command;

public abstract class AppicationService<E extends Command, R> {

	public abstract R process(E form);

}
