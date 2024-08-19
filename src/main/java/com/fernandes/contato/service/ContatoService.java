package com.fernandes.contato.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fernandes.contato.repository.IContato;

public class ContatoService {
	
	@Autowired
	IContato contatoRepository;

}
