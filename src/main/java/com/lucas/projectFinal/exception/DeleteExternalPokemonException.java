package com.lucas.projectFinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Not possible to delete external pokemons!")
public class DeleteExternalPokemonException extends RuntimeException {
}