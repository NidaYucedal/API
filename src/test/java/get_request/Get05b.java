package get_request;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get05b extends ReqresBaseUrl {


    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */


    @Test
    public void get05() {

        spec.pathParams("first","unknown","second",3);
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


        SoftAssert softAssert=new SoftAssert();
        JsonPath json = response.jsonPath();
       // System.out.println(json.getInt("data.id"));

        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        softAssert.assertEquals(json.getInt("data.id"),3);
        softAssert.assertEquals(json.getString("data.name"),"true red","Hatali giris");
        softAssert.assertEquals(json.getString("data.year"),"2002","year degeri dogru degil");
        softAssert.assertEquals(json.getString("data.color"),"#BF1932","color degeri dogru degil");

        softAssert.assertEquals(json.getString("data.pantone_value"),
                "19-1664","pantone degeri dogru degil");

        softAssert.assertEquals(json.getString("support.url"),
                "https://reqres.in/#support-heading","url degeri dogru degil");

        softAssert.assertEquals(json.getString("support.text"),
                "To keep ReqRes free, contributions towards server costs are appreciated!",
                "text degeri dogru degil");

        softAssert.assertAll();




    }
}
