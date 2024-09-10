package com.fernandes.contato.service;

import java.util.List;
import java.util.Optional;

import javax.management.ServiceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.contato.entities.Contato;
import com.fernandes.contato.repository.IContato;
import com.fernandes.contato.service.exception.ContatoNotFoundException;
import com.fernandes.contato.service.exception.DadosEssencialException;

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
	
	public Contato update(Contato contato, Integer id) {
		Contato buscarContato = findById(id);
		verificaDadosEssencial(contato);
		Contato contatoAtualizado = autalizarContato(contato, buscarContato);

		return contatoRepository.save(contatoAtualizado);
	}
	
	// https://www.baeldung.com/spring-boot-bean-validation
	// Fazer essa validação para aprender!!!
	private void verificaDadosEssencial(Contato contato) {
		if (contato.getNome().isEmpty() || contato.getCpf().isEmpty()) {
			throw new DadosEssencialException();
		}
		
	}

	public Contato autalizarContato(Contato contatoAntigo, Contato contatoNovo) {
		contatoNovo.setNome(contatoAntigo.getNome());
		contatoNovo.setCelular(contatoAntigo.getCelular());
		contatoNovo.setTipo(contatoAntigo.getTipo());
		contatoNovo.setCpf(contatoAntigo.getCpf());
		
		return contatoNovo;
	}
}
