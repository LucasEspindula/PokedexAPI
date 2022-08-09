package com.lucas.projectFinal.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(schema = "public")
public class Type {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@NotBlank
    @Column(length = 20, nullable = false)
    private String name;
    
    @ManyToMany(cascade = CascadeType.ALL, 
    	fetch = FetchType.LAZY, 
    	mappedBy = "types")
    private List<Pokemon> pokemons;

	public Type(String name) {
		this.name = name;
	}
}