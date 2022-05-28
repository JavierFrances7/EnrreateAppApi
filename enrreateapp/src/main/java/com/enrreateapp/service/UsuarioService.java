package com.enrreateapp.service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.enrreateapp.model.Usuario;

@Service
public class UsuarioService implements UsuarioServiceInterface {
   private static Map<String, Usuario> usuarioRepositorio = new HashMap<>();
   
   @Override
   public void createUsuario(Usuario usuario) {
	   usuarioRepositorio.put(usuario.getUidUsuario(), usuario);
   }
   @Override
   public void updateUsuario(String uidUsuario, Usuario usuario) {
	   usuarioRepositorio.remove(uidUsuario);
	   usuario.setUidUsuario(uidUsuario);
      usuarioRepositorio.put(uidUsuario, usuario);
   }
   @Override
   public void deleteUsuario(String id) {
	   usuarioRepositorio.remove(id);

   }
   @Override
   public Collection<Usuario> getUsuarios() {
      return usuarioRepositorio.values();
   }
}