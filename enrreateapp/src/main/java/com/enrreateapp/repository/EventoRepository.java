package com.enrreateapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enrreateapp.model.Evento;


public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
