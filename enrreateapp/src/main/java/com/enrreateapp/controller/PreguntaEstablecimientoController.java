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


import com.enrreateapp.DTO.CreatePreguntaEstablecimientoDTO;
import com.enrreateapp.DTO.PreguntaEstablecimientoDTO;
import com.enrreateapp.DTO.PreguntaEstablecimientoDTOConverter;
import com.enrreateapp.exceptions.ApiError;
import com.enrreateapp.exceptions.PreguntaEstablecimientoNotFoundException;
import com.enrreateapp.model.PreguntaEstablecimiento;
import com.enrreateapp.repository.PreguntaEstablecimientoRepository;

@CrossOrigin
@RestController
public class PreguntaEstablecimientoController {


	private final PreguntaEstablecimientoRepository preguntaEstablecimientoRepository;
	private final PreguntaEstablecimientoDTOConverter preguntaEstablecimientoDTOConverter;

	public PreguntaEstablecimientoController(PreguntaEstablecimientoRepository preguntaEstablecimientoRepository,
			PreguntaEstablecimientoDTOConverter preguntaEstablecimientoDTOConverter) {
		this.preguntaEstablecimientoRepository = preguntaEstablecimientoRepository;
		this.preguntaEstablecimientoDTOConverter = preguntaEstablecimientoDTOConverter;
	}

	/**
	 * Obtenemos todas los preguntas
	 * 
	 * @return
	 */

	@GetMapping("/api/preguntas/establecimientos")
	public ResponseEntity<?> obtenerTodos() {
		List<PreguntaEstablecimiento> result = preguntaEstablecimientoRepository.findAll();

		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			List<PreguntaEstablecimientoDTO> dtoList = result.stream().map(preguntaEstablecimientoDTOConverter::convertirADto)
					.collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}

	}

	/**
	 * Obtenemos una pregunta por el id
	 * 
	 * @return
	 */

	@GetMapping("/api/preguntas/establecimiento/{id_pregunta}")
	public ResponseEntity<?> obtenerUno(@PathVariable int id_pregunta)
			throws PreguntaEstablecimientoNotFoundException {
		PreguntaEstablecimiento result = preguntaEstablecimientoRepository.findById(id_pregunta).orElse(null);

		if (result == null)
			throw new PreguntaEstablecimientoNotFoundException(
					"ERROR: Pregunta no encontrada con el id: " + id_pregunta);
		else
			return ResponseEntity.ok(preguntaEstablecimientoDTOConverter.convertirADto(result));
	}
	

	// Método para crear una pregunta 

	@PostMapping("/api/preguntas/establecimiento")
	public ResponseEntity<?> nuevoPreguntaEstablecimiento(@RequestBody CreatePreguntaEstablecimientoDTO nuevo) {
		PreguntaEstablecimiento preguntaEstablecimiento = preguntaEstablecimientoDTOConverter.convertirAPreguntaEstablecimiento(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(preguntaEstablecimientoRepository.save(preguntaEstablecimiento));
	}

	// Método para actualizar una pregunta

	@PutMapping("/api/preguntas/establecimiento/{id_pregunta}")
	public ResponseEntity<?> editarPreguntaEstablecimiento(@RequestBody CreatePreguntaEstablecimientoDTO editar,
			@PathVariable int id_pregunta) throws PreguntaEstablecimientoNotFoundException {
		if (preguntaEstablecimientoRepository.existsById(id_pregunta)) {
			PreguntaEstablecimiento preguntaEstablecimiento = preguntaEstablecimientoDTOConverter.convertirAPreguntaEstablecimiento(editar);
			preguntaEstablecimiento = preguntaEstablecimientoRepository.save(preguntaEstablecimiento);
			return new ResponseEntity<>(preguntaEstablecimientoDTOConverter.convertirADto(preguntaEstablecimiento), HttpStatus.OK);

		} else {
			throw new PreguntaEstablecimientoNotFoundException(
					"La pregutna con ID: " + id_pregunta + " no existe.");
		}
	}

	// Método para borrar una pregunta

	@DeleteMapping("/api/preguntas/establecimiento/{id_pregunta}")
	public ResponseEntity<?> borrarPreguntaEstablecimiento(@PathVariable int id_pregunta) {
		PreguntaEstablecimiento result = preguntaEstablecimientoRepository.findById(id_pregunta).orElse(null);
		if (preguntaEstablecimientoRepository.existsById(id_pregunta)) {
			preguntaEstablecimientoRepository.delete(result);
			return ResponseEntity.noContent().build();
		} else
			return ResponseEntity.notFound().build();
	}

	public ResponseEntity<ApiError> handlePreguntaEstablecimientoNoEncontrado(PreguntaEstablecimientoNotFoundException ex) {
		ApiError apiError = new ApiError();
		apiError.setEstado(HttpStatus.NOT_FOUND);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
}
