package steps;

import endpoints.PokemonEndpoints;
import io.qameta.allure.Step;
import io.restassured.response.Response;


public class PokemonSteps extends BaseSteps {

    @Step("Get list of pokemons")
    public static Response getAllOfPokemons() {
        return PokemonEndpoints.getListOfPokemon();
    }

    @Step("Get pokemon by name")
    public static Response getPokemon(String name) {
        return PokemonEndpoints.getPokemonByName(name);
    }

    @Step("Verify ability")
    public static boolean verifyPokemonHasAbility (String pokemon, String ability) {
        return PokemonEndpoints.verifyPokemonAbility(pokemon, ability);
    }
}
