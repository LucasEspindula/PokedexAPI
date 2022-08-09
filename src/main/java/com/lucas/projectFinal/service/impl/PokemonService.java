package com.lucas.projectFinal.service.impl;

import com.lucas.projectFinal.model.Pokemon;
import com.lucas.projectFinal.service.dto.PokemonDTO;
import com.lucas.projectFinal.converter.PokemonConverter;
import com.lucas.projectFinal.exception.DeleteExternalPokemonException;
import com.lucas.projectFinal.exception.PokemonDuplicatedException;
import com.lucas.projectFinal.exception.PokemonNotFoundException;
import com.lucas.projectFinal.exception.UpdateExternalPokemonException;
import com.lucas.projectFinal.infra.repository.PokemonRepository;

import static com.lucas.projectFinal.converter.PokemonConverter.*;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PokemonService {

	private final PokemonResponseService pokeResponseService;
	private final PokemonRepository pokeRepository;

	@Autowired
	public PokemonService(PokemonResponseService pokeResponseService, PokemonRepository pokeRepository) {
		this.pokeResponseService = pokeResponseService;
		this.pokeRepository = pokeRepository;
	}

	public PokemonDTO getPokeById(Integer id) {
		try {
			return responseToDTO(pokeResponseService.responseFindById(id));
		} catch (HttpClientErrorException e) {
			return entityToDto(pokeRepository.findById(id).orElseThrow(() -> new PokemonNotFoundException()));
		}
	}

	public PokemonDTO getPokeByName(String pokeName) {
		try {
			return responseToDTO(pokeResponseService.responseFindByName(pokeName));
		} catch (HttpClientErrorException e) {
			return entityToDto(pokeRepository.findByName(pokeName).orElseThrow(() -> new PokemonNotFoundException()));
		}
	}

	public List<PokemonDTO> getPokeByWeight(Integer weight) {
		return pokeRepository.FindPokemonByWeight(weight).stream().map(PokemonConverter::entityToDto).toList();
	}

	public void modifyPoke(PokemonDTO pokemonDTO) {
		try {
			if (pokeResponseService.pokeAlreadyExistsExternalyByName(pokemonDTO.getName())) {
				throw new UpdateExternalPokemonException();
			}
			pokeRepository.save(dtoToEntity(pokemonDTO));
		} catch (HttpClientErrorException e) {
			pokeRepository.findByNameAndNotDeleted(pokemonDTO.getName())
					.orElseThrow(() -> new PokemonNotFoundException());
		}
	}

	public void deletePokeInternaty(String name) {                    
		if (pokeResponseService.pokeAlreadyExistsExternalyByName(name)) {
			throw new DeleteExternalPokemonException();
		}

		var pokemonFiltrado = pokeRepository.findByNameAndNotDeleted(name)
				.orElseThrow(() -> new PokemonNotFoundException());

		pokemonFiltrado.isPokeDeleted();
		pokeRepository.save(pokemonFiltrado);
	}

	public PokemonDTO createPoke(@Valid Pokemon pokemon) {
		pokeAlreadyExists(pokemon);
		return entityToDto(pokeRepository.save(pokemon));
	}

	private void pokeAlreadyExists(@Valid Pokemon pokemon) {
		boolean pokeExistExternally = pokeResponseService
				.pokeAlreadyExistsExternalyByName(pokemon.getName().toLowerCase());
		boolean pokeExistsInternally = pokeRepository.pokeAlreadyExistsInternallyByName(pokemon.getName()) > 0;

		if (pokeExistExternally || pokeExistsInternally) {
			throw new PokemonDuplicatedException();
		}
	}
}
