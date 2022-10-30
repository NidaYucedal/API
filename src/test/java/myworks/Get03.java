package myworks;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Get03 extends ReqresBaseUrl {


    //https://reqres.in/api/users/12

    /*
    {
    "data": {
        "id": 12,
        "email": "rachel.howell@reqres.in",
        "first_name": "Rachel",
        "last_name": "Howell",
        "avatar": "https://reqres.in/img/faces/12-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}

     */

    @Test
    public void get03() {

        spec.pathParams("first", "users", "second", 12);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        //response.prettyPrint();
        System.out.println(response.contentType());

        SoftAssert softAssert = new SoftAssert();
        JsonPath json = response.jsonPath();
        System.out.println(json.getInt("data.id"));

        // Do Assertion
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        softAssert.assertEquals(json.getString("data.first_name"),"Rachel");
        softAssert.assertEquals(json.getString("data.last_name"),"Howell");


    }
}
