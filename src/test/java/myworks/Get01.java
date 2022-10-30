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

        Response response = given().spec(spec).when().get("/{first}");

      SoftAssert softAssert = new SoftAssert();
      // softAssert.assertEquals(response.statusCode(), 200);
      // softAssert.assertEquals(response.contentType(), "text/html; charset=utf-8");
      // softAssert.assertEquals(response.statusLine(), "200 OK");


        JsonPath jsonPath = response.jsonPath();

        List<String> womenList = jsonPath.getList("products.category.usertype.usertype");
        System.out.println(womenList.size());
        System.out.println(womenList);
        int womenIndex = 0;
        int menIndex = 0;
        int kidsIndex = 0;
        for (String w : womenList
        ) {
            if (w.equals("Women")) {
                womenIndex++;
            } else if (w.equals("Men")) {
                menIndex++;
            } else if (w.equals("Kids")) {
                kidsIndex++;
            }
        }
        System.out.println("kidsIndex = " + kidsIndex);
        System.out.println("menIndex = " + menIndex);
        System.out.println("womenIndex = " + womenIndex);
        softAssert.assertEquals(womenIndex, 12);
        softAssert.assertEquals(menIndex, 9);
        softAssert.assertEquals(kidsIndex, 13);
        softAssert.assertAll();


    }
}
