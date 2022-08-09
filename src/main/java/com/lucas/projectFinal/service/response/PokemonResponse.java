package com.lucas.projectFinal.service.response;

import java.util.List;

public class PokemonResponse {

	private Integer id;
	private String name;
	private Integer height;
	private Integer weight;
	private List<MoveResponse> moves;
	private List<TypesResponse> types;
	
	@Deprecated
	public PokemonResponse() {}

	public PokemonResponse(Integer id, String name, Integer height, Integer weight, List<MoveResponse> moves,
			List<TypesResponse> types) {
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.moves = moves;
		this.types = types;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getHeight() {
		return height;
	}

	public Integer getWeight() {
		return weight;
	}

	public List<MoveResponse> getMoves() {
		return moves;
	}

	public List<TypesResponse> getTypes() {
		return types;
	}
}
