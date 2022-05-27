package com.enrreateapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends Exception{
	

	public UsuarioNotFoundException(String mensaje) {
		super(mensaje);
	}

}
