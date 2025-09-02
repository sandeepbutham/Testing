package apiframwork;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
public class TokenManager {

	
	 private static String token;
	    private static long expiryTime;

	    public static String getToken() {
	        // if token is null OR expired -> generate new
	        if (token == null || System.currentTimeMillis() > expiryTime) {
	            Response res = given()
	                    .baseUri("https://api.example.com")
	                    .header("Content-Type", "application/json")
	                    .body("{\"username\":\"testuser\", \"password\":\"testpass\"}")
	            .when()
	                    .post("/auth/token")
	            .then()
	                    .statusCode(200)
	                    .extract().response();

	            token = res.jsonPath().getString("access_token");
	            int expiresIn = res.jsonPath().getInt("expires_in"); // e.g. 3600 seconds
	            expiryTime = System.currentTimeMillis() + (expiresIn * 1000);
	        }
	        return token;
	
	    }}
	

