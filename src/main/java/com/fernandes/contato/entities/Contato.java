package com.fernandes.contato.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fernandes.contato.enums.TipoCelular;

public class Contato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String cpf;
	private String celular;
	private TipoCelular tipo;
	
	
	public Contato() {}
	
	public Contato(String nome, String cpf, String celular, TipoCelular tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
	
	

}
