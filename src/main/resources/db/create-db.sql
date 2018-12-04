--DROP TABLE users IF EXISTS;

CREATE TABLE users (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50)
);

CREATE TABLE pokemons (
  idPokemon INTEGER PRIMARY KEY auto_increment,
  name VARCHAR(30),
  weight  VARCHAR(5),
  speciesUrl VARCHAR(200),
  speciesName VARCHAR(30)
);