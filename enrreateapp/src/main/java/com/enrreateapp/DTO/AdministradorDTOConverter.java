package com.enrreateapp.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.enrreateapp.model.Administrador;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AdministradorDTOConverter {

	private final ModelMapper modelMapper = new ModelMapper();

	public AdministradorDTO convertirADto(Administrador administrador) {
		return modelMapper.map(administrador, AdministradorDTO.class);
	}

	public Administrador convertirAAdministrador(CreateAdministradorDTO createAdministradorDto) {
		return modelMapper.map(createAdministradorDto, Administrador.class);
	}

	public AdministradorUidsDTO convertirUidsADto(Administrador administrador) {
		return modelMapper.map(administrador, AdministradorUidsDTO.class);
	}
	
}
