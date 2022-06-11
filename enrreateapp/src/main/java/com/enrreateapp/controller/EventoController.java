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

import com.enrreateapp.DTO.CreateEventoDTO;
import com.enrreateapp.DTO.EventoDTO;
import com.enrreateapp.DTO.EventoDTOConverter;
import com.enrreateapp.exceptions.ApiError;
import com.enrreateapp.exceptions.EventoNotFoundException;
import com.enrreateapp.model.Evento;
import com.enrreateapp.repository.EventoRepository;

@CrossOrigin
@RestController
public class EventoController {


	private final EventoRepository eventoRepository;
	private final EventoDTOConverter eventoDTOConverter;

	public EventoController(EventoRepository eventoRepository,
			EventoDTOConverter eventoDTOConverter) {
		this.eventoRepository = eventoRepository;
		this.eventoDTOConverter = eventoDTOConverter;
	}

	/**
	 * Obtenemos todos los eventos
	 * 
	 * @return
	 */

	@GetMapping("/api/eventos")
	public ResponseEntity<?> obtenerTodos() {
		List<Evento> result = eventoRepository.findAll();

		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			List<EventoDTO> dtoList = result.stream().map(eventoDTOConverter::convertirADto)
					.collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}

	}

	/**
	 * Obtenemos un evento por el id
	 * 
	 * @return
	 */

	@GetMapping("/api/eventos/{id_evento}")
	public ResponseEntity<?> obtenerUno(@PathVariable int id_evento)
			throws EventoNotFoundException {
		Evento result = eventoRepository.findById(id_evento).orElse(null);

		if (result == null)
			throw new EventoNotFoundException(
					"ERROR: Eventos no encontrado con el id: " + id_evento);
		else
			return ResponseEntity.ok(eventoDTOConverter.convertirADto(result));
	}
	

	// Método para crear evento

	@PostMapping("/api/evento")
	public ResponseEntity<?> nuevoEvento(@RequestBody CreateEventoDTO nuevo) {
		Evento evento = eventoDTOConverter.convertirAEvento(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoRepository.save(evento));
	}

	// Método para actualizar un evento

	@PutMapping("/api/evento/{id_evento}")
	public ResponseEntity<?> editarEvento(@RequestBody Evento editar,
			@PathVariable int id_evento) throws EventoNotFoundException {
		if (eventoRepository.existsById(id_evento)) {
			editar.setIdEvento(id_evento);
			return ResponseEntity.ok(eventoRepository.save(editar));

		} else {
			throw new EventoNotFoundException(
					"El evento con ID: " + id_evento + " no existe.");
		}
	}

	// Método para borrar un evento

	@DeleteMapping("/api/evento/{id_evento}")
	public ResponseEntity<?> borrarEvento(@PathVariable int id_evento) {
		Evento result = eventoRepository.findById(id_evento).orElse(null);
		if (eventoRepository.existsById(id_evento)) {
			eventoRepository.delete(result);
			return ResponseEntity.noContent().build();
		} else
			return ResponseEntity.notFound().build();
	}

	public ResponseEntity<ApiError> handleEventoNoEncontrado(EventoNotFoundException ex) {
		ApiError apiError = new ApiError();
		apiError.setEstado(HttpStatus.NOT_FOUND);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
}
