package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;

import static org.apache.http.HttpStatus.SC_OK;

public class BaseSteps {

    @Step("Verify response code 200")
    public static void verifyResponseCode200(Response response){
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Response code is incorrect");
    }
}
