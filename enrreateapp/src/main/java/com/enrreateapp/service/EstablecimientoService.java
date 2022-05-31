package com.enrreateapp.service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.enrreateapp.model.Establecimiento;
import com.enrreateapp.model.Usuario;

@Service
public class EstablecimientoService implements EstablecimientoServiceInterface {
   private static Map<String, Establecimiento> establecimientoRepositorio = new HashMap<>();
   
   @Override
   public void createEstablecimiento(Establecimiento establecimiento) {
	   establecimientoRepositorio.put(establecimiento.getUidEstablecimiento(), establecimiento);
   }
   @Override
   public void updateEstablecimiento(String uidEstablecimiento, Establecimiento establecimiento) {
	   establecimientoRepositorio.remove(uidEstablecimiento);
	   establecimiento.setUidEstablecimiento(uidEstablecimiento);
	   establecimientoRepositorio.put(uidEstablecimiento, establecimiento);
   }
   @Override
   public void deleteEstablecimiento(String id) {
	   establecimientoRepositorio.remove(id);

   }
   @Override
   public Collection<Establecimiento> getEstablecimientos() {
      return establecimientoRepositorio.values();
   }
}