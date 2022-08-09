package com.lucas.projectFinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Not possible to update external pokemons!")
public class UpdateExternalPokemonException extends RuntimeException {
}