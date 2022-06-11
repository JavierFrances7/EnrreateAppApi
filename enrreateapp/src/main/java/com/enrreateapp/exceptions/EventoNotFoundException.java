package com.enrreateapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventoNotFoundException extends Exception{
	

	public EventoNotFoundException(String mensaje) {
		super(mensaje);
	}

}
