package com.lucas.projectFinal.converter;

import com.lucas.projectFinal.model.Pokemon;
import com.lucas.projectFinal.model.Move;
import com.lucas.projectFinal.model.Type;
import com.lucas.projectFinal.service.dto.PokemonDTO;
import com.lucas.projectFinal.service.response.PokemonResponse;

public class PokemonConverter {
	
	//response pra dto
	public static PokemonDTO responseToDTO(PokemonResponse response) {
        return new PokemonDTO(
                response.getId(),
                response.getName(),
                response.getHeight(),
                response.getWeight(), 
                response.getTypes()
                        .stream()
                        .map(type -> new Type(type.getType().getName()))
                        .toList(),
                response.getMoves()
                        .stream()
                        .map(move -> new Move(move.getMove().getName()))
                        .toList()        
        );                
    }
	
	//entidade pra dto
    public static PokemonDTO entityToDto(Pokemon entity) {
        return new PokemonDTO(
        		entity.getName(),
        		entity.getHeight(),
        		entity.getWeight(), 
        		entity.getTypes()
                        .stream()
                        .map(type -> new Type(type.getName()))
                        .toList(),
                entity.getMoves()
                        .stream()
                        .map(move -> new Move(move.getName()))
                        .toList() 
        );
    }
    
    //dto pra entidade
    public static Pokemon dtoToEntity (PokemonDTO dto) {
    	return new Pokemon(
    			dto.getName(),
    			dto.getHeight(),
    			dto.getWeight(), 
    			dto.getTypes()
                        .stream()
                        .map(type -> new Type(type.getName()))
                        .toList(),
                dto.getMoves()
                        .stream()
                        .map(move -> new Move(move.getName()))
                        .toList() 
    			);
    }
}
