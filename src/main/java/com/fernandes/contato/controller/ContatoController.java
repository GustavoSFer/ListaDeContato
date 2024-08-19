package com.fernandes.contato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandes.contato.service.ContatoService;

@RestController
@RequestMapping(value = "/Contato")
public class ContatoController {
	
	@Autowired
	ContatoService contatoService;

}
