package com.fernandes.contato.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fernandes.contato.service.exception.ContatoNotFoundException;
import com.fernandes.contato.service.exception.DadosEssencialException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ContatoNotFoundException.class)
	public ResponseEntity<StartedErrorException> notFound(ContatoNotFoundException e, HttpServletRequest request) {
		String mensagem = e.getMessage();
		HttpStatus status = HttpStatus.NOT_FOUND;
		StartedErrorException erro = new StartedErrorException(mensagem, false);
		
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(DadosEssencialException.class)
	public ResponseEntity<StartedErrorException> dadosEssencialNotFound(DadosEssencialException e, HttpServletRequest request) {
		String mensagem = e.getMessage();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StartedErrorException erro = new StartedErrorException(mensagem, false);
		
		return ResponseEntity.status(status).body(erro);
	}

}
