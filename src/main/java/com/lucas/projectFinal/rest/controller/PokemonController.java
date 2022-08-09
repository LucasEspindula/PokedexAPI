package com.lucas.projectFinal.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lucas.projectFinal.model.Pokemon;
import com.lucas.projectFinal.service.dto.PokemonDTO;
import com.lucas.projectFinal.service.impl.PokemonService;

@RestController
@RequestMapping("/api/v1")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> getPokemonById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(pokemonService.getPokeById(id));
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonDTO> getPokemonByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(pokemonService.getPokeByName(name));
    }
    
    @GetMapping("/weight")
    public ResponseEntity<List<PokemonDTO>> getPokemonsByWeight(@RequestParam("weight") Integer weight) {
        return ResponseEntity.ok(pokemonService.getPokeByWeight(weight));
    }
    
    @DeleteMapping("/{name}")
    public void deletePokemon(@PathVariable("name") String name) {
        pokemonService.deletePokeInternaty(name);
    }
    
    @PostMapping
    public ResponseEntity<PokemonDTO> registerNewPoke(@RequestBody @Valid Pokemon pokemon) {
        return new ResponseEntity<>(pokemonService.createPoke(pokemon), HttpStatus.CREATED);
    }
    
    @PutMapping
    public void updatePokemon(@RequestBody @Valid PokemonDTO pokemonDto) {
        pokemonService.modifyPoke(pokemonDto);
    }
}
