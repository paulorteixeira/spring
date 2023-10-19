package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pokemon;
import com.example.demo.service.PokeService;

@RestController
@RequestMapping("pokemons")
public class PokeController {
    
	@Autowired
	private PokeService pokemonService;

	@GetMapping
	public ResponseEntity<Iterable<Pokemon>> buscarTodos() {
		return ResponseEntity.ok(pokemonService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pokemon> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(pokemonService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Pokemon> inserir(@RequestBody Pokemon pokemon) {
		System.out.println("<<<<<<<<<<<<<<<<<<");
		pokemonService.inserir(pokemon);
		return ResponseEntity.ok(pokemon);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pokemon> atualizar(@PathVariable Long id, @RequestBody Pokemon pokemon) {
		pokemonService.atualizar(id, pokemon);
		return ResponseEntity.ok(pokemon);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		pokemonService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
