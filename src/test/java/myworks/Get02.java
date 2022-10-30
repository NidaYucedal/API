package myworks;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get02 extends RestfulBaseUrl {

    //https://restful-booker.herokuapp.com/booking

    //status code

    //status Line


    @Test
    public void get02() {

        spec.pathParam("first","booking");

        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        System.out.println(response.contentType());
        response.then().
                assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType("application/json; charset=utf-8");


    }
}
