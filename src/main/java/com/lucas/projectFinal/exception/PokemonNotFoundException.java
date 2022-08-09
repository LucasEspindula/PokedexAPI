package com.lucas.projectFinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Pokemon not found!")
public class PokemonNotFoundException extends RuntimeException {
}