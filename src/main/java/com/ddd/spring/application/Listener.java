package com.ddd.spring.application;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class Listener {

	@EventListener
	public void onMessage(Event event) {
		System.out.println("Mensagem publicada com sucesso: " + event.mensagem());
		System.out.println("Valor: " + event.value());
	}

	@Order(1) //<- setar ordem, mas não é recomendado
	@EventListener
	public void onFailure(TransactionFailureEvent event) {
		System.out.println("A failure ocurs => ");
		System.out.println(event.getMensagem());
	}
}
