package com.fernandes.contato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.contato.repository.IContato;

@Service
public class ContatoService {
	
	@Autowired
	IContato contatoRepository;

}
