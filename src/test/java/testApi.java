import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class testApi {
    String requestBody = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";

    @Test
    public void get(){
        given().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);
    }
    @Test
    public void post(){
        given().contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://reqres.in/api/users")
                .then().log().body();
    }
}
