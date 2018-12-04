package pl.sda.jdbc.jdbc.rest;

import org.springframework.http.ResponseEntity;
import pl.sda.jdbc.jdbc.Exception.RestNotFoundException;
import pl.sda.jdbc.jdbc.Exception.RestPokemonException;
import pl.sda.jdbc.jdbc.dto.PokemonDto;

import java.util.List;

public interface PokemonRestInterface {
    ResponseEntity<Integer> count();

    //PokemonDto addPokemonBody();

    ResponseEntity<Integer> addNewPokemon(PokemonDto pokemonDto) throws RestPokemonException;

    ResponseEntity deletePokemon(int id);

    ResponseEntity<List<PokemonDto>> findAllPokemons();

    ResponseEntity<PokemonDto> findById(int id) throws RestPokemonException, RestNotFoundException;

    ResponseEntity<PokemonDto> findByName(String name) throws RestNotFoundException;


}
