package com.enrreateapp.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.enrreateapp.model.Usuario;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioDTOConverter {

	private final ModelMapper modelMapper = new ModelMapper();

	public UsuarioDTO convertirADto(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioDTO.class);
	}

	public Usuario convertirAUsuario(CreateUsuarioDTO createUsuarioDto) {
		return modelMapper.map(createUsuarioDto, Usuario.class);
	}

	public UsuarioUidsDTO convertirUidsADto(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioUidsDTO.class);
	}

	public UsuarioCompletoDTO convertirCompletoADto(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioCompletoDTO.class);
	}
}
