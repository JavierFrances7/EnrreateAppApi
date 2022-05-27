package com.enrreateapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enrreateapp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
