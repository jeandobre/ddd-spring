package com.ddd.spring.application;

public class Event {

	private String mensagem;
	private Double value;

	public Event(String mensagem, Double value) {
		this.mensagem = mensagem;
		this.value = value;
	}

	public String mensagem() {
		return mensagem;
	}

	public Double value() {
		return value;
	}
}
