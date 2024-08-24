package com.fernandes.contato.service.exception;

public class ContatoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ContatoNotFoundException(Object id) {
		super("Contato com o id " + id + " não encontrado.");
	}

}
