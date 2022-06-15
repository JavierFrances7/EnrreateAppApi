package com.enrreateapp.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.enrreateapp.model.Administrador;
import com.enrreateapp.model.ComentarioEstablecimiento;
import com.enrreateapp.model.Establecimiento;
import com.enrreateapp.model.Evento;
import com.enrreateapp.model.PreguntaEstablecimiento;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PreguntaEstablecimientoDTOConverter {

	private final ModelMapper modelMapper = new ModelMapper();

	public PreguntaEstablecimientoDTO convertirADto(PreguntaEstablecimiento preguntaEstablecimiento) {
		return modelMapper.map(preguntaEstablecimiento, PreguntaEstablecimientoDTO.class);
	}
	
	public PreguntaEstablecimiento convertirAPreguntaEstablecimiento(CreatePreguntaEstablecimientoDTO createPreguntaEstablecimientoDTO) {
		return modelMapper.map(createPreguntaEstablecimientoDTO,PreguntaEstablecimiento.class);
	}
	
}
