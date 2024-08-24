package com.fernandes.contato.controller.exception;

import java.io.Serializable;

public class StartedErrorException implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String erro;
	private boolean status;
	
	public StartedErrorException(String erro, boolean status) {
		this.erro = erro;
		this.status = status;
	}
	
	public String getErro() {
		return erro;
	}
	
	public void setErro(String erro) {
		this.erro = erro;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
