package com.fernandes.contato.service;

import java.util.List;
import java.util.Optional;

import javax.management.ServiceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.contato.entities.Contato;
import com.fernandes.contato.repository.IContato;
import com.fernandes.contato.service.exception.ContatoNotFoundException;

@Service
public class ContatoService {
	
	@Autowired
	IContato contatoRepository;
	
	public Contato createContato(Contato contato) {
		return contatoRepository.save(contato);
	}

	public List<Contato> findAll() {
		List<Contato> contatos = contatoRepository.findAll();
		
		return contatos;
	}
	
	public Contato findById(Integer id) {
		Optional<Contato> contato = contatoRepository.findById(id);
				
		return contato.orElseThrow(() -> new ContatoNotFoundException(id));
	}
}
