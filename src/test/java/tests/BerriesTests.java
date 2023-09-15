package tests;

import io.restassured.response.Response;
import jdk.jfr.Description;
import model.Berry;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static steps.BerriesSteps.getBerry;

public class BerriesTests {

    @Test
    @Description("GET /")
    public void verifyCheriBerryId () {
        //GIVEN
        String name = "cheri";
        int id = 1;

        //WHEN
        Response response = getBerry(name);
        System.out.println(response.getBody().asPrettyString());

        //THEN
        Assert.assertEquals(id, response.getBody().as(Berry.class).getId());
    }
}
