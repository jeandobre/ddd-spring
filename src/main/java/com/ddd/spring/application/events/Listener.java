package com.ddd.spring.application.events;

import com.ddd.spring.application.Event;
import com.ddd.spring.application.TransactionFailureEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Listener {

	@EventListener
	@Async
	public void onMessage(Event event) {

		System.out.println("Mensagem publicada com sucesso: " + event.mensagem());
		System.out.println("Valor: " + event.value());

	}

	@Order(1) //<- setar ordem, mas não é recomendado
	@EventListener
	@Async
	public void onMessage2(Event event) throws InterruptedException {
		System.out.println("Staring()...");
		Thread.sleep(3000);
		System.out.println("Mensagem 2 publicada com sucesso: " + event.mensagem());
		System.out.println("Valor: " + event.value());
		System.out.println("Ending()...");

	}


	@EventListener
	public void onFailure(TransactionFailureEvent event)  {

		System.out.println("A failure ocurs => ");
		System.out.println(event.getMensagem());

	}
}
