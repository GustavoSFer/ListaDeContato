package com.fernandes.contato.service.exception;

public class DadosEssencialException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public DadosEssencialException() {
		super("Nome ou CPF não informado.");
	}

}
