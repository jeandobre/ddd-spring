package com.ddd.spring.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

	@Autowired
	ApplicationEventPublisher applicationEventPublisher;

	public void sendMoney(String mensagem, Double value, boolean condition) {
		try {
			if(condition)
				throw new RuntimeException("Ooopss");

			System.out.println("Mensagem publicada: " + mensagem);

			applicationEventPublisher.publishEvent(new Event(mensagem, value));
		} catch (RuntimeException ex){
			applicationEventPublisher.publishEvent(new TransactionFailureEvent(mensagem, value));
			ex.printStackTrace();
		}

	}
}
