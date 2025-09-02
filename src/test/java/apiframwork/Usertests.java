package apiframwork;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class Usertests extends Basecalss


{
	
	

    @Test
    public void createUserTest() throws IOException {
        String body = "{ \"username\": \"sandeep\", \"case\": \"123\" }";
        //or
        //if json added in resppruces
        String body1 = Jsonutils.readJson("src/test/resources/payloads/updateUser.json");
       // or
		/*
		 * // Replace placeholders in JSON String body =
		 * JsonUtils.readJson("src/test/resources/payloads/createUser.json")
		 * .replace("{{USERNAME}}", "sandeep") .replace("{{CASE_ID}}", "123");
		 */

        Response res = given()
                .spec(reqSpec)
                .body(body1)
        .when()
                .post("/users")
        .then()
                .spec(resSpec)
                .body("username", equalTo("sandeep"))
                .extract().response();

        System.out.println("Created user ID: " + res.jsonPath().getInt("id"));
    }

    @Test
    public void getUserTest() {
        given()
                .spec(reqSpec)
                .pathParam("id", 1)
        .when()
                .get("/users/{id}")
        .then()
                .spec(resSpec)
                .body("id", equalTo(1));
    }
}
	 
	


