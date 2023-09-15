package endpoints;

import helpers.PropertyManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Pokemon;

import static io.restassured.RestAssured.given;

public class PokemonEndpoints extends BaseEndpoint {
    public static final String POKEMON_ENDPOINT = PropertyManager.getProperty("pokemon.url");
    public static final String POKEMON_BY_NAME = PropertyManager.getProperty("pokemon.by.name.url");


    public static Response getListOfPokemon() {
        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .log().all()
                .get(POKEMON_ENDPOINT)
                .then().extract().response();
    }

    public static Response getPokemonByName(String name) {
        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .log().all()
                .get(POKEMON_BY_NAME, name)
                .then().extract().response();
    }

    public static boolean verifyPokemonAbility (String pokemon, String ability) {
        return getPokemonByName(pokemon).getBody().as(Pokemon.class)
                .getAbilities().stream()
                .anyMatch(e -> e.getAbility().get("name").equals(ability));
    }
}
