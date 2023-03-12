package Helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TempAPI {

    RequestSpecification httpRequest;
    Response response;
    String url = "http://localhost:3000/";

    @Test
    public void testingAPI(){
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given().auth().preemptive().basic("admin", "admin");

        //Get Request
        response = httpRequest.get("/api/teams/search");

        response.prettyPrint();
    }

}
