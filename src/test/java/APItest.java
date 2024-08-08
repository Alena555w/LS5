import io.qameta.allure.testng.AllureTestNg;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.http.HttpResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Listeners({AllureTestNg.class})
public class APItest {
    @Test
    void testGetListUsers() {
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("/users?page=2")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", is(not(empty())));
    }


    @Test
    void postLoginUnsuccessful() {
        String body = "{\n" +
                "  \"email\": \"peter@klaven\"\n" +
                "}";

        given()
                .baseUri("https://reqres.in/api")
                .contentType("application/json")
                .body(body)
                .log().all()
                .when()
                .post("/login")
                .then()
                .log().all()
                .statusCode(400)
                .body(not(emptyString()))
                .body("error", equalTo("Missing password"));
    }

    @Test
    void testDeleteUser() {
        String body = "{\n" +
                "  \"name\": \"morpheus\",\n" +
                "  \"job\": \"zion resident\"\n" +
                "}";

        given()
                .baseUri("https://reqres.in/api")
                .contentType("application/json")
                .body(body)
                .log().all()
                .when()
                .put("/api/users/2")
                .then()
                .log().all()
                .statusCode(200)
                .body(not(emptyString()))
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion resident"));

    }
}

