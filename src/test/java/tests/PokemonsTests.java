package tests;

import io.restassured.response.Response;
import jdk.jfr.Description;
import model.Pokemon;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static steps.BaseSteps.verifyResponseCode200;
import static steps.PokemonSteps.*;

public class PokemonsTests {

    @Test
    @Description("GET /pokemon verify response code 200 ")
    public void verifyResponse200onGetPokemons() {
        //WHEN
        Response response = getAllOfPokemons();

        //THEN
        verifyResponseCode200(response);
    }

    @Test
    @Description("GET /pokemon/{$}")
    public void verifyClefairyWeight() {
        //GIVEN
        String name = "clefairy";
        int weight = 75;

        //WHEN
        Response response = getPokemon(name);

        //THEN
        Assert.assertEquals(weight, response.getBody().as(Pokemon.class).getWeight(), "Clefairy's weight is incorrect");
    }

    @Test
    @Description("GET /pokemon/{$}")
    public void verifyStuffulAbility() {
        //GIVEN
        String name = "stufful";
        String ability = "fluffy";

        //WHEN
        boolean result = verifyPokemonHasAbility(name, ability);

        //THEN
        Assert.assertTrue(result, "Pokemon " + name + " doesn't have an ability " + ability);
    }
}
