package com.enrreateapp.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enrreateapp.DTO.ComentarioEstablecimientoDTO;
import com.enrreateapp.DTO.ComentarioEstablecimientoDTOConverter;
import com.enrreateapp.DTO.CreateComentarioEstablecimientoDTO;
import com.enrreateapp.exceptions.ApiError;
import com.enrreateapp.exceptions.ComentarioEstablecimientoNotFoundException;
import com.enrreateapp.model.ComentarioEstablecimiento;
import com.enrreateapp.repository.ComentarioEstablecimientoRepository;

@CrossOrigin
@RestController
public class ComentarioEstablecimientoController {


	private final ComentarioEstablecimientoRepository comentarioEstablecimientoRepository;
	private final ComentarioEstablecimientoDTOConverter comentarioEstablecimientoDTOConverter;

	public ComentarioEstablecimientoController(ComentarioEstablecimientoRepository comentarioEstablecimientoRepository,
			ComentarioEstablecimientoDTOConverter comentarioEstablecimientoDTOConverter) {
		this.comentarioEstablecimientoRepository = comentarioEstablecimientoRepository;
		this.comentarioEstablecimientoDTOConverter = comentarioEstablecimientoDTOConverter;
	}

	/**
	 * Obtenemos todos los comentarios asociados a establecimientos
	 * 
	 * @return
	 */

	@GetMapping("/api/comentarios/establecimientos")
	public ResponseEntity<?> obtenerTodos() {
		List<ComentarioEstablecimiento> result = comentarioEstablecimientoRepository.findAll();

		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			List<ComentarioEstablecimientoDTO> dtoList = result.stream().map(comentarioEstablecimientoDTOConverter::convertirADto)
					.collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}

	}

	/**
	 * Obtenemos un comentario por el id
	 * 
	 * @return
	 */

	@GetMapping("/api/comentarios/establecimiento/{id_comentario}")
	public ResponseEntity<?> obtenerUno(@PathVariable int id_comentario)
			throws ComentarioEstablecimientoNotFoundException {
		ComentarioEstablecimiento result = comentarioEstablecimientoRepository.findById(id_comentario).orElse(null);

		if (result == null)
			throw new ComentarioEstablecimientoNotFoundException(
					"ERROR: Comentarios no encontrado con el id: " + id_comentario);
		else
			return ResponseEntity.ok(comentarioEstablecimientoDTOConverter.convertirADto(result));
	}
	

	// Método para crear un comentario establecimiento

	@PostMapping("/api/comentarios/establecimiento")
	public ResponseEntity<?> nuevoComentarioEstablecimiento(@RequestBody CreateComentarioEstablecimientoDTO nuevo) {
		ComentarioEstablecimiento comentarioEstablecimiento = comentarioEstablecimientoDTOConverter.convertirAComentarioEstablecimiento(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(comentarioEstablecimientoRepository.save(comentarioEstablecimiento));
	}

	// Método para actualizar un comentario establecimiento

	@PutMapping("/api/comentarios/establecimiento/{id_comentario}")
	public ResponseEntity<?> editarComentarioEstablecimiento(@RequestBody ComentarioEstablecimiento editar,
			@PathVariable int id_comentario) throws ComentarioEstablecimientoNotFoundException {
		if (comentarioEstablecimientoRepository.existsById(id_comentario)) {
			editar.setIdComentario(id_comentario);
			return ResponseEntity.ok(comentarioEstablecimientoRepository.save(editar));

		} else {
			throw new ComentarioEstablecimientoNotFoundException(
					"El comentario con ID: " + id_comentario + " no existe.");
		}
	}

	// Método para borrar un comentario

	@DeleteMapping("/api/comentarios/establecimiento/{id_comentario}")
	public ResponseEntity<?> borrarComentarioEstablecimiento(@PathVariable int id_comentario) {
		ComentarioEstablecimiento result = comentarioEstablecimientoRepository.findById(id_comentario).orElse(null);
		if (comentarioEstablecimientoRepository.existsById(id_comentario)) {
			comentarioEstablecimientoRepository.delete(result);
			return ResponseEntity.noContent().build();
		} else
			return ResponseEntity.notFound().build();
	}

	public ResponseEntity<ApiError> handleComentarioEstablecimientoNoEncontrado(ComentarioEstablecimientoNotFoundException ex) {
		ApiError apiError = new ApiError();
		apiError.setEstado(HttpStatus.NOT_FOUND);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
}
