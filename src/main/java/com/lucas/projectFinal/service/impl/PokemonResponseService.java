package com.lucas.projectFinal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lucas.projectFinal.service.response.PokemonResponse;

@Service
public class PokemonResponseService {

	@Value("${pokemon-external-api}")
	private String pokemonUri;
	private final RestTemplate restTemplate;

	public PokemonResponseService(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	private String urlIntegrationById(Integer id) {
		return this.pokemonUri + "/" + id;
	}

	public PokemonResponse responseFindById(Integer id) {
		String url = urlIntegrationById(id);
		return this.restTemplate.getForObject(url, PokemonResponse.class);
	}

	private String urlIntegrationByName(String name) {
		return this.pokemonUri + "/" + name;
	}

	public PokemonResponse responseFindByName(String name) {
		String url = urlIntegrationByName(name);
		return this.restTemplate.getForObject(url, PokemonResponse.class);
	}

	public boolean pokeAlreadyExistsExternalyByName(String name) {
		String url = urlIntegrationByName(name);
		try {
			restTemplate.getForObject(url, PokemonResponse.class);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}
}
