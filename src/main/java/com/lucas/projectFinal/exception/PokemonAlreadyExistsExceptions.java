package com.lucas.projectFinal.exception;

@SuppressWarnings("serial")
public class PokemonAlreadyExistsExceptions extends RuntimeException{
    public PokemonAlreadyExistsExceptions(String message) {
        super(message);
    }
}