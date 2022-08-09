package com.lucas.projectFinal.service.dto;

import java.util.List;

import javax.persistence.*;

import com.lucas.projectFinal.model.Move;
import com.lucas.projectFinal.model.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDTO {
	
	@Id
	private Integer id;
    private String name;
    private Integer height;
    private Integer weight;
	private List<Type> types;
    private List<Move> moves;
    
	public PokemonDTO(String name, Integer height, Integer weight, List<Type> types, List<Move> moves) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.types = types;
		this.moves = moves;
	} 
}
