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

import com.enrreateapp.DTO.AdministradorDTO;
import com.enrreateapp.DTO.AdministradorDTOConverter;
import com.enrreateapp.DTO.AdministradorUidsDTO;
import com.enrreateapp.DTO.CreateAdministradorDTO;
import com.enrreateapp.exceptions.AdministradorNotFoundException;
import com.enrreateapp.exceptions.ApiError;
import com.enrreateapp.model.Administrador;
import com.enrreateapp.repository.AdministradorRepository;

@RestController
public class AdministradorController {

	// Se declara como final pq no se va a modificar este repositorio se inyecta
	// solo al crear el bean controlador
	private final AdministradorRepository administradorRepositorio;
	private final AdministradorDTOConverter administradorDTOConverter;

	public AdministradorController(AdministradorRepository administradorRepositorio,
			AdministradorDTOConverter administradorDTOConverter) {
		super();
		this.administradorRepositorio = administradorRepositorio;
		this.administradorDTOConverter = administradorDTOConverter;
	}

	/**
	 * Obtenemos todos los admins
	 * 
	 * @return
	 */

	@GetMapping("/api/administradores")
	public ResponseEntity<?> obtenerTodos() {
		List<Administrador> result = administradorRepositorio.findAll();

		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			List<AdministradorDTO> dtoList = result.stream().map(administradorDTOConverter::convertirADto)
					.collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}

	}

	/**
	 * Obtenemos un administrador por el id
	 * 
	 * @return
	 */

	@GetMapping("/api/administradores/{uid_administrador}")
	public ResponseEntity<?> obtenerUno(@PathVariable String uid_administrador) throws AdministradorNotFoundException {
		Administrador result = administradorRepositorio.findById(uid_administrador).orElse(null);

		if (result == null)
			throw new AdministradorNotFoundException("ERROR: Admin no encontrado con el id: " + uid_administrador);
		else
			return ResponseEntity.ok(administradorDTOConverter.convertirADto(result));
	}

	/**
	 * Obtenemos todos las uids de los usuarios del tipo admin
	 * 
	 * @return
	 */

	@GetMapping("/api/administradores/uids")
	public ResponseEntity<?> obtenerUids() {
		List<Administrador> result = administradorRepositorio.findAll();

		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			List<AdministradorUidsDTO> dtoList = result.stream().map(administradorDTOConverter::convertirUidsADto)
					.collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}

	}

	// Método para crear admin

	@PostMapping("/api/administrador")
	public ResponseEntity<?> nuevoAdministrador(@RequestBody CreateAdministradorDTO nuevo) {
		Administrador administrador = administradorDTOConverter.convertirAAdministrador(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(administradorRepositorio.save(administrador));
	}

	// Método para actualizar admin

	@PutMapping("/api/administradores/{uid_administrador}")
	public ResponseEntity<?> editarAdministrador(@RequestBody Administrador editar,
			@PathVariable String uid_administrador) throws AdministradorNotFoundException {
		if (administradorRepositorio.existsById(uid_administrador)) {
			editar.setUidAdministrador(uid_administrador);
			return ResponseEntity.ok(administradorRepositorio.save(editar));

		} else {
			throw new AdministradorNotFoundException(
					"El administrador con ID: " + uid_administrador + " no existe.");
		}
	}

	// Método para borrar admin

	@DeleteMapping("/api/administrador/{uid_administrador}")
	public ResponseEntity<?> borrarAdministrador(@PathVariable String uid_administrador) {
		Administrador result = administradorRepositorio.findById(uid_administrador).orElse(null);
		if (administradorRepositorio.existsById(uid_administrador)) {
			administradorRepositorio.delete(result);
			return ResponseEntity.noContent().build();
		} else
			return ResponseEntity.notFound().build();
	}

	public ResponseEntity<ApiError> handleAdministradorNoEncontrado(AdministradorNotFoundException ex) {
		ApiError apiError = new ApiError();
		apiError.setEstado(HttpStatus.NOT_FOUND);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
}
