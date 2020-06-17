package adapters;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.ResourceData;
import models.ResourceList;

import static io.restassured.RestAssured.given;

public class UnknownAdapter extends MainAdapter {

    public ResourceList GetList(){
        Response response =
        given()
                .header("Content-Type", "application/json")
                .log().all()
        .when()
                .get("https://reqres.in/api/unknown")
        .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), ResourceList.class);
    }

    public ResourceData GetResourceById(int id, int expectedHttpCode){
        Response response =
         given()
                .header("Content-type", "application/json")
         .when()
                .get(String.format("https://reqres.in/api/unknown/%s", id))
         .then()
                .log().all()
                .statusCode(expectedHttpCode)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), ResourceData.class);
    }
}
