package com.ddd.spring.application;

public class TransactionFailureEvent {

	private final String mensagem;
	private final Double value;

	public TransactionFailureEvent(final String mensagem, final Double value) {
		this.mensagem = mensagem;
		this.value = value;
	}

	public String getMensagem() {
		return mensagem;
	}

	public Double getValue() {
		return value;
	}
}
