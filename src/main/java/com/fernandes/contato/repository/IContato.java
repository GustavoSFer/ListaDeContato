package com.fernandes.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernandes.contato.entities.Contato;

@Repository
public interface IContato extends JpaRepository<Contato, Integer> {

}
