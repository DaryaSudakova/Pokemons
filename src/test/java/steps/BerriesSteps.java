package steps;

import endpoints.BerriesEndpoint;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class BerriesSteps {

    @Step("Get list of berries")
    public static Response getListOfBerries() {
        return BerriesEndpoint.getListOfBerries();
    }
    @Step("Get berry by name")
    public static Response getBerry(String name) {
        return BerriesEndpoint.getBerriesByName(name);
    }
}
