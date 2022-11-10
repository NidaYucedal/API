package delete_request;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDeletePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete02 extends DummyRestApiBaseUrl {

    /*
     URL: https://dummy.restapiexample.com/api/v1/delete/2
     HTTP Request Method: DELETE Request
     Test Case: Type by using Gherkin Language
     Assert:     i) Status code is 200
                 ii) "status" is "success"
                 iii) "data" is "2"
                 iv) "message" is "Successfully! Record has been deleted"



            Given
            URL: https://dummy.restapiexample.com/api/v1/delete/2
            When
            HTTP Request Method: DELETE Request
            Test Case: Type by using Gherkin Language
            Then
            Status code is 200
            And
             "status" is "success"
            And
             "data" is "2"
            And
            "message" is "Successfully! Record has been deleted"


       */

    @Test
    public void del02() {

        spec.pathParams("first", "delete", "second", 2);

        DummyRestApiDeletePojo expectedData = new DummyRestApiDeletePojo("success", "2", "Successfully! Record has been deleted");
        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        DummyRestApiDeletePojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiDeletePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getData(),actualData.getData());
        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getMessage(),actualData.getMessage());

    }
}
