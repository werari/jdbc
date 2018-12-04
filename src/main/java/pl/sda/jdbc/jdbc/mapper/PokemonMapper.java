package pl.sda.jdbc.jdbc.mapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pl.sda.jdbc.jdbc.Domain.PokemonDomain;
import pl.sda.jdbc.jdbc.dto.PokemonDto;
import pl.sda.jdbc.jdbc.dto.SpeciesDto;
import pl.sda.jdbc.jdbc.service.PokemonServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonMapper implements RowMapper<PokemonDomain> {


    @Override
    public PokemonDomain mapRow(ResultSet resultSet, int i) throws SQLException {

        PokemonDomain pokemonDomain = new PokemonDomain();
        pokemonDomain.setIdPokemon(resultSet.getInt("idPokemon"));
        pokemonDomain.setName(resultSet.getString("name"));
        pokemonDomain.setWeight(resultSet.getInt("weight"));
        pokemonDomain.setSpeciesName(resultSet.getString("speciesUrl"));
        pokemonDomain.setSpeciesUrl(resultSet.getString("speciesName"));
        return pokemonDomain;
    }
}

