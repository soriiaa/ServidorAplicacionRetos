package com.alejandrogonzalo.ServidorRetos.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorExceptions {

	@ExceptionHandler(EmailExistenteException.class)
	@ResponseStatus(HttpStatus.CONFLICT) // Devuelve HTTP 409
	public Map<String, String> manejarEmailExistente(EmailExistenteException ex) {
		Map<String, String> error = new HashMap<>();
		error.put("error", ex.getMessage());
		return error;
	}

	@ExceptionHandler(NicknameExistenteException.class)
	@ResponseStatus(HttpStatus.CONFLICT) // Devuelve HTTP 409
	public Map<String, String> manejarNicknameExistente(NicknameExistenteException ex) {
		Map<String, String> error = new HashMap<>();
		error.put("error", ex.getMessage());
		return error;
	}
	
}
