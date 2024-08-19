package com.fernandes.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernandes.contato.entities.Contato;

public interface IContato extends JpaRepository<Contato, Integer> {

}
