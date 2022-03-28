package com.ddd.spring.application.events;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextListener {

	@EventListener
	public void onInicializedEvent(ContextRefreshedEvent event) {
		System.out.println("application initalized or refreshed");
		System.out.println(event);
	}

	@EventListener
	public void onInicializedEvent(ContextClosedEvent event) {
		System.out.println("application closed");
		System.out.println(event);
	}

	@EventListener
	public void onInicializedEvent(ContextStoppedEvent event) {
		System.out.println("application stop");
		System.out.println(event);
	}
}
