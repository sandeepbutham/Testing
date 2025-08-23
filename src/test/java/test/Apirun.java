package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Apirun {

	public static String title;
	//added comment..from github
	public static void get() 
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		

        Response res = 
        		given()  
        		.header("Content-Type","Application/Json")
        		.queryParam("userId","1")
        		.pathParam("id",1)
        		.auth().preemptive().basic("username", "password")
            .when()
                .get("/posts/{id}")
                .then()
                .statusCode(200)
                .extract()
                .response();
        
        System.out.println(res.getStatusCode());
        
        System.out.println(res.asString());
     int id=   res.jsonPath().getInt("id");
   title=  res.jsonPath().getString("title");
        
          
		
	}
	
	public static void post() 
	{
		Response res=given()
		.header("Content-type","Application/json")
		.header("Authorization","Bearer" + "")
		.body("\\\"name\\\":\\\"Sandeep\\\", \\\"role\\\":\\\"QA\\\" }")
		.when()
		.post("/createusers")
		.then()
		.statusCode(201)
		.extract().response();
int id=		res.jsonPath().getInt("id");
String name=		res.jsonPath().get("name");
		
		
	}//added bracet
	
	public static void main(String[] args) {
		get();

	}

}
