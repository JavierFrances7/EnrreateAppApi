package com.enrreateapp.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.enrreateapp.model.Administrador;
import com.enrreateapp.model.Establecimiento;
import com.enrreateapp.model.Evento;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EventoDTOConverter {

	private final ModelMapper modelMapper = new ModelMapper();

	public EventoDTO convertirADto(Evento evento) {
		return modelMapper.map(evento, EventoDTO.class);
	}
	
	public Evento convertirAEvento(CreateEventoDTO createEventoDTO) {
		return modelMapper.map(createEventoDTO,Evento.class);
	}
	
}
