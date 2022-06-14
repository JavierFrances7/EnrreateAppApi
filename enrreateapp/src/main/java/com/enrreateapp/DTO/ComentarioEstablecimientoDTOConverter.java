package com.enrreateapp.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.enrreateapp.model.Administrador;
import com.enrreateapp.model.ComentarioEstablecimiento;
import com.enrreateapp.model.Establecimiento;
import com.enrreateapp.model.Evento;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ComentarioEstablecimientoDTOConverter {

	private final ModelMapper modelMapper = new ModelMapper();

	public ComentarioEstablecimientoDTO convertirADto(ComentarioEstablecimiento comentarioEstablecimiento) {
		return modelMapper.map(comentarioEstablecimiento, ComentarioEstablecimientoDTO.class);
	}
	
	public ComentarioEstablecimiento convertirAComentarioEstablecimiento(CreateComentarioEstablecimientoDTO createComentarioEstablecimientoDTO) {
		return modelMapper.map(createComentarioEstablecimientoDTO,ComentarioEstablecimiento.class);
	}
	
}
