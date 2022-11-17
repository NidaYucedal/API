package put_request;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {

    /*
        URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }


                   Given
    URL: https://dummy.restapiexample.com/api/v1/update/21
When
    PUT Request
      Request body: {
                    "employee_name": "Ali Can",
                    "employee_salary": 111111,
                    "employee_age": 23,
                    "profile_image": "Perfect image"
                 }
Then
    i) Status code is 200
And
    ii) Response body should be like the following
                {
                    "status": "success",
                    "data": {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                    },
                    "message": "Successfully! Record has been updated."
                }

     */

    @Test
    public void put02() {

        spec.pathParams("first", "update", "second", 21);

        DummyRestApiDataPojo data = new DummyRestApiDataPojo("Ali Can", "Perfect image", 111111, 23);
        DummyRestApiPojo expectedData = new DummyRestApiPojo("success", data, "Successfully! Record has been updated.");
        System.out.println("expectedData = " + expectedData);

        Response response=given().spec(spec).contentType(ContentType.JSON).body(data).when().put("/{first}/{second}");
        response.prettyPrint();

        DummyRestApiPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getMessage(),expectedData.getMessage());


        assertEquals(expectedData.getData().getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(data.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(data.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(data.getProfile_image(),actualData.getData().getProfile_image());





    }
}
