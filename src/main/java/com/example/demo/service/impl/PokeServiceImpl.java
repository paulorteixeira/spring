package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pokemon;
import com.example.demo.model.PokemonRepository;
import com.example.demo.service.POKEAPIService;
import com.example.demo.service.PokeService;


@Service
public class PokeServiceImpl implements PokeService{

    @Autowired
	private PokemonRepository pokemonRepository;
	@Autowired
	private POKEAPIService pokeapiService;

    @Override
    public Iterable<Pokemon> buscarTodos() {
        
        return pokemonRepository.findAll();
    }

    @Override
    public Pokemon buscarPorId(Long id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
		return pokemon.get();
    }

    @Override
    public void inserir(Pokemon pokemon) {
        
       salvarPokemon(pokemon.getId()) ; 
     }

    @Override
    public void atualizar(Long id, Pokemon cliente) {
        
        Optional<Pokemon> clienteBd = pokemonRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarPokemon(cliente.getId());
		}    
    }

    @Override
	public void deletar(Long id) {
		// Deletar Cliente por ID.
		pokemonRepository.deleteById(id);
	}

    private void salvarPokemon(Long id) {

		Pokemon pk = pokemonRepository.findById(id).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Pokemon novoPokemon = pokeapiService.consultaPokemonId(id);
			pokemonRepository.save(novoPokemon);
			return novoPokemon;
		});

		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		pokemonRepository.save(pk);
	}
    
}
