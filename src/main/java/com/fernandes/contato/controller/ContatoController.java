package com.fernandes.contato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandes.contato.entities.Contato;
import com.fernandes.contato.service.ContatoService;

@RestController
@RequestMapping(value = "/Contato")
public class ContatoController {
	
	@Autowired
	ContatoService contatoService;
	
	@PostMapping
	public ResponseEntity<Contato> createContato(@RequestBody Contato contato) {
		Contato contatoSalvo = contatoService.createContato(contato);
		
		return ResponseEntity.ok().body(contatoSalvo);
	}

}
