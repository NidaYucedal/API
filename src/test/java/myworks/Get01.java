package myworks;

import base_urls.AutoBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get01 extends AutoBaseUrl {


    /*
Given
    https://automationexercise.com/api/productsList
When
    User sends a GET Request to the url
Then
    HTTP Status Code should be 200
And
    Content Type should be "text/html; charset=utf-8"
And
    Status Line should be HTTP/1.1 200 OK
And
     There must be 12 Women, 9 Men, 13 Kids usertype in products
  */


    @Test
    public void get01() {

       spec.pathParam("first", "productsList");

       Response response = given().spec(spec).contentType(ContentType.JSON).when().get("{first}");
       response.prettyPrint();


       List<HashMap<String,Object>> pro;

      JsonPath json = response.jsonPath();
      pro = json.getList("products");
      System.out.println(pro);
      SoftAssert softAssert = new SoftAssert();
      softAssert.assertEquals(response.statusCode(), 200);
      softAssert.assertEquals(response.contentType(), "text/html; charset=utf-8");
      softAssert.assertEquals(response.statusLine(), "200 OK");



      softAssert.assertAll();


    }
}
