package com.enrreateapp.DTO;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.enrreateapp.model.Establecimiento;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EstablecimientoDTOConverter {

	private final ModelMapper modelMapper = new ModelMapper();
	
	public EstablecimientoDTO convertirADto(Establecimiento establecimiento) {
		return modelMapper.map(establecimiento, EstablecimientoDTO.class);
	}
	
	public Establecimiento convertirAEstablecimiento(CreateEstablecimientoDTO createEstablecimientoDto) {
		return modelMapper.map(createEstablecimientoDto,Establecimiento.class);
	}
	
	public EstablecimientoUidsDTO convertirUidsADto(Establecimiento establecimiento) {
		return modelMapper.map(establecimiento, EstablecimientoUidsDTO.class);
	}
	
}
