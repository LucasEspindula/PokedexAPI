package com.lucas.projectFinal.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(schema = "public")
public class Move {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@NotBlank
    @Column(length = 20, nullable = false)
	private String name;
    
    @ManyToMany(cascade = CascadeType.ALL, 
    	fetch = FetchType.LAZY, 
    	mappedBy = "moves")
    private List<Pokemon> pokemons;

	public Move(String name) {
		this.name = name;
	}
}