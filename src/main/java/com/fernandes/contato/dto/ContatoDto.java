package com.fernandes.contato.dto;

import java.io.Serializable;

import com.fernandes.contato.entities.Contato;
import com.fernandes.contato.enums.TipoCelular;

public class ContatoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String celular;
	private TipoCelular tipo;
	
	
	public ContatoDto() {}
	
	public ContatoDto(Contato obj) {
		this.nome = obj.getNome();
		this.celular = obj.getCelular();
		this.tipo = obj.getTipo();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public TipoCelular getTipo() {
		return tipo;
	}

	public void setTipo(TipoCelular tipo) {
		this.tipo = tipo;
	}
}
