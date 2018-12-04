package pl.sda.jdbc.jdbc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.jdbc.jdbc.Exception.RestPokemonException;
import pl.sda.jdbc.jdbc.dto.PokemonDto;
import pl.sda.jdbc.jdbc.service.PokemonService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PokemonRestImpl implements PokemonRestInterface {
    private PokemonService pokemonService;

    @Autowired
    public PokemonRestImpl(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/count")
    @Override
    public ResponseEntity<Integer> count() {
        int count = pokemonService.count();
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(count);
    }

    @PostMapping("/addNewPokemon")
    @Override
    public ResponseEntity<Integer> addNewPokemon(@RequestBody PokemonDto pokemonDto) throws RestPokemonException {
        int i = pokemonService.addNewPokemon(pokemonDto);
        if (i < 0) throw new RestPokemonException();

        return ResponseEntity.status(HttpStatus.CREATED).body(i);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Void> deletePokemon(@PathVariable (value = "id") int id) {

        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

    @GetMapping("/findByAll")
    @Override
    public ResponseEntity<List<PokemonDto>> findAllPokemons() {

        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.findAllPokemons());
    }

    @GetMapping("/findById")
    @Override
    public ResponseEntity<PokemonDto> findById(@RequestParam int id) throws RestPokemonException {
        PokemonDto byId = pokemonService.findById(id);
        if (byId != null) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(byId);
        } else {
            throw new RestPokemonException();
        }
    }

    @GetMapping("/findByName")
    @Override
    public ResponseEntity<PokemonDto> findByName(@RequestParam String name) {
        PokemonDto byName = pokemonService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(byName);
    }
}
