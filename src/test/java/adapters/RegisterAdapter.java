package adapters;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.RegisterSuccessfulResponse;
import models.RegistrationData;
import org.apache.http.protocol.HTTP;

import static io.restassured.RestAssured.given;

public class RegisterAdapter extends MainAdapter {

    public RegisterSuccessfulResponse registerUser(RegistrationData user, int expectedHttpCode) {

        Response response =
                given()
                        .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                        .body(gson.toJson(user))
                        .log().all()
                .when()
                        .post("https://reqres.in/api/register")
                .then()
                        .log().all()
                        .statusCode(expectedHttpCode)
                        .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), RegisterSuccessfulResponse.class);
    }
}
