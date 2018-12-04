package pl.sda.jdbc.jdbc.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.jdbc.jdbc.dto.SpeciesDto;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PokemonDomain {

private int idPokemon;
    private String name;
    private int weight;

    private String speciesName;
    private String speciesUrl;
}
