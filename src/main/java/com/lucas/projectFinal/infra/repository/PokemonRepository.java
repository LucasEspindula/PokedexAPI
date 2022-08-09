package com.lucas.projectFinal.infra.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lucas.projectFinal.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    
	@Query("SELECT p FROM Pokemon p WHERE p.id = :id")
    Optional<Pokemon> findById(@Param("id") Integer id);
    
	@Query("SELECT p FROM Pokemon p WHERE p.name LIKE %:name%")
    Optional<Pokemon> findByName(@Param("name") String name);
	
	@Query("SELECT p FROM Pokemon p WHERE p.name LIKE %:name% AND poke_deleted = false")
    Optional<Pokemon> findByNameAndNotDeleted(@Param("name") String name);
	
    @Query("SELECT count(p) FROM Pokemon p WHERE p.name LIKE %:name%")
    Integer pokeAlreadyExistsInternallyByName(@Param("name") String name);
    
    @Query("SELECT p FROM Pokemon p WHERE p.weight = :weight")
    List<Pokemon> FindPokemonByWeight(@Param("weight") Integer weight);
}
