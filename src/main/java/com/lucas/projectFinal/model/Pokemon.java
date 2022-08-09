package com.lucas.projectFinal.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(schema = "public")
public class Pokemon {
	
	@Id
	@SequenceGenerator(initialValue = 906, name = "continue_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "continue_sequence")
	private Integer id;
	
	@Getter
	@NotBlank
    @Column(length = 20, nullable = false)
    private String name;
	
	@Getter
	@NotNull
	@Positive
    private Integer height;
	
	@Getter
	@NotNull
	@Positive
    private Integer weight;
	
    @SuppressWarnings("unused")
	private boolean pokeDeleted;
    
	@Getter
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pokemon_type",
		schema = "public",
		joinColumns = { @JoinColumn(name = "pokemon_id") },
		inverseJoinColumns = { @JoinColumn(name = "type_id") })
    private List<Type> types;
    
	@Getter
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pokemon_move",
		schema = "public",
		joinColumns = { @JoinColumn(name = "pokemon_id") },
		inverseJoinColumns = { @JoinColumn(name = "move_id") })
    private List<Move> moves;
    
	public Pokemon(String name, Integer height, Integer weight, List<Type> types, List<Move> moves) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.types = types;
		this.moves = moves;
	}

	public boolean isPokeDeleted() {
		return pokeDeleted = true;
	}
}