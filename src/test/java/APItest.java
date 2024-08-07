import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.net.http.HttpResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APItest {
    @Test
    void getListOfUsers(){
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200);
    }


    @Test
    void getListOfUsersCheckBody(){
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200)
                .body(not(emptyString()));
    }

    @Test
    void getListOfUsersCheckBodyField(){
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200)
                .body("per_page", equalTo(6));
    }

    @Test
    void getListOfUsersCheckBodyFieldData(){
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("/users/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("data.first_name", equalTo("George"));
    }

    @Test
    void postCreateUser(){
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        given()
                .baseUri("https://reqres.in/api")
                .contentType("application/json")
                .body(body)
                .log().all()
                .when()
                .post("/users")
                .then()
                .log().all()
                .statusCode(201)
                .body(not(emptyString()))
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));

    }

}
