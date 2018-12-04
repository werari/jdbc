package pl.sda.jdbc.jdbc.service;

import pl.sda.jdbc.jdbc.Domain.PokemonDomain;
import pl.sda.jdbc.jdbc.dto.PokemonDto;

import java.util.List;
import java.util.Optional;

public interface PokemonService {
    int count();

    int addNewPokemon(PokemonDto pokemonDto);

    void deletePokemon(int id);

    List<PokemonDto> findAllPokemons();

    PokemonDto findById(int id);

    Optional<PokemonDto> findByName(String name);
    PokemonDto convertPokemonToDto(PokemonDomain pok);
}
