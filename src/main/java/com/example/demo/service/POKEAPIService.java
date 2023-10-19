package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Pokemon;

@FeignClient(name="pokeapi", url = "https://pokeapi.co/api/v2/pokemon/")
public interface POKEAPIService {
    
    @RequestMapping(method = RequestMethod.GET,value="/{name}")
    Pokemon consultaPokemonNome(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.GET,value="/{id}")
    Pokemon consultaPokemonId(@PathVariable("id") Long id);
}
