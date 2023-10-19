package com.example.demo.service;

import com.example.demo.model.Pokemon;

public interface PokeService {
    Iterable<Pokemon> buscarTodos();

	Pokemon buscarPorId(Long id);

	void inserir(Pokemon Pokemon);

	void atualizar(Long id, Pokemon cliente);

	void deletar(Long id);

}
