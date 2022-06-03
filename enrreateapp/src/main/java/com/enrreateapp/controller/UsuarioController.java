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

import com.enrreateapp.DTO.CreateUsuarioDTO;
import com.enrreateapp.DTO.UsuarioDTO;
import com.enrreateapp.DTO.UsuarioDTOConverter;
import com.enrreateapp.DTO.UsuarioUidsDTO;
import com.enrreateapp.exceptions.ApiError;
import com.enrreateapp.exceptions.UsuarioNotFoundException;
import com.enrreateapp.model.Usuario;
import com.enrreateapp.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	// Se declara como final pq no se va a modificar este repositorio se inyecta
	// solo al crear el bean controlador
	private final UsuarioRepository usuarioRepositorio;
	private final UsuarioDTOConverter usuarioDTOConverter;

	public UsuarioController(UsuarioRepository usuarioRepositorio, UsuarioDTOConverter usuarioDTOConverter) {
		this.usuarioRepositorio = usuarioRepositorio;
		this.usuarioDTOConverter = usuarioDTOConverter;
	}

	// Método que obtiene todos los usuarios

	@GetMapping("/api/usuarios")
	public ResponseEntity<?> obtenerTodos() {
		List<Usuario> result = usuarioRepositorio.findAll();

		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			List<UsuarioDTO> dtoList = result.stream().map(usuarioDTOConverter::convertirADto)
					.collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}

	}

	// Metodo que obtiene un usuario por el id

	@GetMapping("/api/usuario/{uid_usuario}")
	public ResponseEntity<?> obtenerUno(@PathVariable String uid_usuario) throws UsuarioNotFoundException {
		Usuario result = usuarioRepositorio.findById(uid_usuario).orElse(null);

		if (result == null)
			throw new UsuarioNotFoundException("ERROR: Usuario no encontrado con el id: " + uid_usuario);
		else
			return ResponseEntity.ok(usuarioDTOConverter.convertirADto(result));
	}

	// Método que obtiene todos los uids de los usuarios normales

	@GetMapping("/api/usuarios/uids")
	public ResponseEntity<?> obtenerUids() {
		List<Usuario> result = usuarioRepositorio.findAll();

		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			List<UsuarioUidsDTO> dtoList = result.stream().map(usuarioDTOConverter::convertirUidsADto)
					.collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}

	}

	// Método para crear usuario

	@PostMapping("/api/usuario")
	public ResponseEntity<?> nuevoUsuario(@RequestBody CreateUsuarioDTO nuevo) {
		Usuario usuario = usuarioDTOConverter.convertirAUsuario(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepositorio.save(usuario));
	}

	// Método para actualizar usuario

	@PutMapping("/api/usuario/{uid_usuario}")
	public ResponseEntity<?> editarUsuario(@RequestBody Usuario editar, @PathVariable String uid_usuario)
			throws UsuarioNotFoundException {
		if (usuarioRepositorio.existsById(uid_usuario)) {
			editar.setUidUsuario(uid_usuario);
			return ResponseEntity.ok(usuarioRepositorio.save(editar));

		} else {
			throw new UsuarioNotFoundException("El usuario con ID: " + uid_usuario + " no existe.");
		}
	}

	// Método para borrar usuario

	@DeleteMapping("/api/usuario/{uid_usuario}")
	public ResponseEntity<?> borrarUsuario(@PathVariable String uid_usuario) {
		Usuario result = usuarioRepositorio.findById(uid_usuario).orElse(null);
		if (usuarioRepositorio.existsById(uid_usuario)) {
			usuarioRepositorio.delete(result);
			return ResponseEntity.noContent().build();
		} else
			return ResponseEntity.notFound().build();
	}

	public ResponseEntity<ApiError> handleUsuarioNoEncontrado(UsuarioNotFoundException ex) {
		ApiError apiError = new ApiError();
		apiError.setEstado(HttpStatus.NOT_FOUND);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
}
