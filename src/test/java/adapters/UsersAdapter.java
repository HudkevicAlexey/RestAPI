package adapters;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.User;
import models.UserCreationResponse;
import models.UsersList;
import org.apache.http.protocol.HTTP;

import static io.restassured.RestAssured.given;

public class UsersAdapter extends MainAdapter {

    public UsersList getUsersByPage(int page) {

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .log().all()
                .when()
                        .get(String.format("https://reqres.in/api/users?page=%s", page))
                .then()
                        .log().all()
                        .statusCode(200)
                        .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), UsersList.class);
    }

    public User getUserById(int id, int expectedHttpCode) {

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .log().all()
                .when()
                        .get(String.format("https://reqres.in/api/users/%s", id))
                        .then()
                .log().all()
                        .statusCode(expectedHttpCode)
                        .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), User.class);
    }

    public UserCreationResponse postUser(UserCreationResponse user) {

        Response response =
                given()
                        .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                        .body(gson.toJson(user))
                        .log().all()
                .when()
                        .post("https://reqres.in/api/users")
                .then()
                        .log().all()
                        .statusCode(201)
                        .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), UserCreationResponse.class);
    }

    public UserCreationResponse putUser(UserCreationResponse postUserJson) {

        Response response =
                given()
                        .body(postUserJson)
                        .header("Content-Type", "application/json")
                        .log().all()
                .when()
                        .put("https://reqres.in/api/users")
                .then()
                        .log().all()
                        .statusCode(200)
                        .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), UserCreationResponse.class);
    }

    public UserCreationResponse patchUser(UserCreationResponse postUserJson) {
        Response response =
                given()
                        .body(postUserJson)
                        .header("Content-Type", "application/json")
                        .log().all()
                .when()
                        .patch("https://reqres.in/api/users")
                .then()
                        .log().all()
                        .statusCode(200)
                        .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), UserCreationResponse.class);
    }

    public static void deleteUserById(int id) {
                given()
                        .header("Content-Type", "application/json")
                        .log().all()
                .when()
                        .delete(String.format("https://reqres.in/api/users/%s",id))
                .then()
                        .log().all()
                        .statusCode(204);
    }
}