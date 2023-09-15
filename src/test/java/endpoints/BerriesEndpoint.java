package endpoints;

import helpers.PropertyManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BerriesEndpoint extends BaseEndpoint {
    public static final String BERRIES_ENDPOINT = PropertyManager.getProperty("berries.url");
    public static final String BERRIES_BY_NAME_ENDPOINT = PropertyManager.getProperty("berries.by.name.url");

    public static Response getListOfBerries(){
        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .log().all()
                .get(BERRIES_ENDPOINT)
                .then().extract().response();
    }

    public static Response getBerriesByName(String name){
        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .log().everything()
                .get(BERRIES_BY_NAME_ENDPOINT, name)
                .then().extract().response();
    }
}
