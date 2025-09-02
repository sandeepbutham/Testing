package apiframwork;

import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.BeforeGroups;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Basecalss {

	
	
	public static RequestSpecification reqSpec;
    public static ResponseSpecification resSpec;

    @BeforeGroups
    public static void setup() {
        reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.example.com")
                .setBasePath("/v1")
                .addHeader("Authorization", "Bearer " + TokenManager.getToken())
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();

        resSpec = new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectResponseTime(lessThan(5000L))
                .build();
    }
	
}
