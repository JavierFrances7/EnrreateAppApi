package com.enrreateapp.service;

import java.util.Collection;

import com.enrreateapp.model.Usuario;

public interface UsuarioServiceInterface {
   public abstract void createUsuario(Usuario usuario);
   public abstract void updateUsuario(String uidUsuario, Usuario usuario);
   public abstract void deleteUsuario(String uidUsuario);
   public abstract Collection<Usuario> getUsuarios();
}