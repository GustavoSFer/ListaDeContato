package com.fernandes.contato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping
	public ResponseEntity<List<Contato>> findAll() {
		List<Contato> contatos = contatoService.findAll();
		
		return ResponseEntity.ok().body(contatos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Contato> findById(@PathVariable Integer id) {
		Contato contato = contatoService.findById(id);
		
		return ResponseEntity.ok().body(contato);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Contato> update(@RequestBody Contato contato, @PathVariable Integer id) {
		Contato contatoAtualizado = contatoService.update(contato, id);
		
		return ResponseEntity.ok().body(contatoAtualizado);
	}
}
