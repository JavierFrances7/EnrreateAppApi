package com.enrreateapp.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enrreateapp.DTO.CreateEstablecimientoDTO;
import com.enrreateapp.DTO.EstablecimientoDTO;
import com.enrreateapp.DTO.EstablecimientoDTOConverter;
import com.enrreateapp.exceptions.ApiError;
import com.enrreateapp.exceptions.EstablecimientoNotFoundException;
import com.enrreateapp.model.Establecimiento;
import com.enrreateapp.repository.EstablecimientoRepository;

@RestController
public class EstablecimientoController { 
	
	private final EstablecimientoRepository establecimientoRepositorio; 
	private final EstablecimientoDTOConverter establecimientoDTOConverter;
	
	public EstablecimientoController(EstablecimientoRepository establecimientoRepositorio, EstablecimientoDTOConverter establecimientoDTOConverter) {
		this.establecimientoRepositorio = establecimientoRepositorio;
		this.establecimientoDTOConverter = establecimientoDTOConverter;
	}
	
	// se declara como final pq no se va a modificar este repositorio

	//se inyecta solo al crear el bean controlador
	
	
	/**
	 * Obtenemos todos los establecimientos
	 * 
	 * @return
	 */
	
	@GetMapping("/api/establecimientos")
	public ResponseEntity<?> obtenerTodos() {
		List<Establecimiento> result=establecimientoRepositorio.findAll();
		
		if(result.isEmpty()) 
			return ResponseEntity.notFound().build();
		else {
			List<EstablecimientoDTO> dtoList=result.stream().map
					(establecimientoDTOConverter::convertirADto).collect
					(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
			
	}
	
	/**
	 * Obtenemos un establecimiento por el id
	 * 
	 * @return
	 */
	
	@GetMapping("/api/establecimiento/{uid_establecimiento}")
	public ResponseEntity<?> obtenerUno(@PathVariable String uid_establecimiento) throws EstablecimientoNotFoundException{
		Establecimiento result=establecimientoRepositorio.findById(uid_establecimiento).orElse(null);
		
		if(result==null)
			throw new EstablecimientoNotFoundException("ERROR: establecimientos no encontrado con el id: " + uid_establecimiento);
			else
			return ResponseEntity.ok(establecimientoDTOConverter.convertirADto(result));
	}
	
	//Método para crear establecimiento
	
	@PostMapping("/api/establecimiento")
	public ResponseEntity<?> nuevoEstablecimiento(@RequestBody CreateEstablecimientoDTO nuevo) {
		Establecimiento establecimiento= establecimientoDTOConverter.convertirAEstablecimiento(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(establecimientoRepositorio.save(establecimiento));
	}

	//Método para actualizar establecimiento
	
	@PutMapping("/api/establecimiento/{uid_establecimiento}")
	public ResponseEntity<?> editarEstablecimiento(@RequestBody Establecimiento editar, @PathVariable String uid_establecimiento) throws EstablecimientoNotFoundException{
		if(establecimientoRepositorio.existsById(uid_establecimiento)) {
			editar.setUidEstablecimiento(uid_establecimiento);
			return ResponseEntity.ok(establecimientoRepositorio.save(editar));

		}else {
			throw new EstablecimientoNotFoundException("El establecimiento con ID: " + uid_establecimiento + " no existe.");
		}
	}
	
	//Método para borrar usuario
	
	@DeleteMapping("/api/establecimiento/{uid_establecimiento}")
	public ResponseEntity<?> editarPedido(@PathVariable String uid_establecimiento){
		Establecimiento result=establecimientoRepositorio.findById(uid_establecimiento).orElse(null);
		if(establecimientoRepositorio.existsById(uid_establecimiento)) {
			establecimientoRepositorio.delete(result);
			return ResponseEntity.noContent().build();
		}else
			return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<ApiError>handleEstablecimientoNoEncontrado(EstablecimientoNotFoundException ex){
		ApiError apiError = new ApiError();
		apiError.setEstado(HttpStatus.NOT_FOUND);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
}
