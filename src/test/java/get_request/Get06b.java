package get_request;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.hasSize;

public class Get06b extends ReqresBaseUrl {


    /*
   Given
          https://reqres.in/api/unknown/
   When
        I send GET Request to the URL
   Then

        1)Status code is 200
        2)Print all pantone_values
        3)Print all ids greater than 3 on the console
          Assert that there are 3 ids greater than 3
        4)Print all names whose ids are less than 3 on the console
          Assert that the number of names whose ids are less than 3 is 2
*/


    @Test
    public void get07() {

        spec.pathParam("first", "unknown");
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();


        assertEquals(200, response.getStatusCode());

        JsonPath json = response.jsonPath();
        System.out.println(json.getList("data.pantone_value"));

        List<Integer> ids = json.getList("data.findAll{it.id>3}.id");
        System.out.println("ids : " + ids);

        assertEquals(3, ids.size());

        List<String> name = json.getList("data.findAll{it.id<3}.name");
        System.out.println("name : " + name);

        assertEquals(2,name.size());






    }
}
