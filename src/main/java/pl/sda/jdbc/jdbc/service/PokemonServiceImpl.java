package pl.sda.jdbc.jdbc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.sda.jdbc.jdbc.Domain.PokemonDomain;
import pl.sda.jdbc.jdbc.dto.PokemonDto;
import pl.sda.jdbc.jdbc.dto.SpeciesDto;
import pl.sda.jdbc.jdbc.mapper.PokemonMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PokemonServiceImpl implements PokemonService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PokemonServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PokemonDto findById(int id) {
        PokemonDomain query;
        try {
            query = this.jdbcTemplate.queryForObject(
                    "SELECT * FROM pokemons WHERE idPokemon = ?", new PokemonMapper(), id);
            return convertPokemonToDto(query);

        } catch (Exception e) {
            log.error("Couldn't find pokemon");
        }
        return null;

    }


    @Override
    public Optional<PokemonDto> findByName(String name) {
        PokemonDomain query;
        try {
            query = this.jdbcTemplate.queryForObject(
                    "select * from pokemons where name=?", new PokemonMapper(), name);
            return Optional.ofNullable(convertPokemonToDto(query));

        } catch (Exception e) {
            log.error("Couldn't find pokemon");
        }
        return Optional.empty();

    }



    @Override
    public List<PokemonDto> findAllPokemons() {

        List<PokemonDomain> pokemonDomainList = this.jdbcTemplate.query(
                "SELECT idPokemon, name, weight, speciesUrl, speciesName FROM pokemons", new PokemonMapper());


        List<PokemonDto> list = new ArrayList<>();
        for (PokemonDomain pok : pokemonDomainList) {
            list.add(convertPokemonToDto(pok));
        }
        return list;
    }

//        return pokemonDomainList
//                .stream()
//                .map(p->convertPokemonToDto(p))
//                .collect(Collectors.toList());
    // }

    public PokemonDto convertPokemonToDto(PokemonDomain pok) {
        return new PokemonDto(pok.getName(), String.valueOf(pok.getWeight()),
                new SpeciesDto(pok.getSpeciesUrl(), pok.getSpeciesName()));
    }


    @Override
    public int addNewPokemon(PokemonDto pokemonDto) {
        // update() służy do inserta i update; w ten sposób jest szybszy niż konkatenacja z +, chodzi tylko o wydajność
        return jdbcTemplate.update("INSERT INTO pokemons(name, weight, speciesUrl, speciesName) VALUES (?,?,?,?)",
                pokemonDto.getName(),
                pokemonDto.getWeight(),
                pokemonDto.getSpecies().getUrl(),
                pokemonDto.getSpecies().getName());
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from pokemons", Integer.class);
    }

    @Override
    public void deletePokemon(int id) {
        jdbcTemplate.queryForObject("delete  from pokemons where id=?", PokemonDto.class);
    }
}