package get_request;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get17 extends DummyRestApiBaseUrl {

    /*
    Given
        URL: https://dummy.restapiexample.com/api/v1/employee/1
    When
        User sends GET Request
    Then
        Status code is 200
    And
        "employee_name" is "Tiger Nixon"
    And
        "employee_salary" is 320800
    And
        "employee_age" is 61
    And
        "status" is "success"
    And
        "message" is "Successfully! Record has been fetched."
     */

    @Test
    public void get17() {

        spec.pathParams("first","employee","second",1);

        DummyRestApiDataPojo data=new DummyRestApiDataPojo("Tiger Nixon","",320800,61);
        DummyRestApiPojo expectedData=new DummyRestApiPojo("success",data,"Successfully! Record has been fetched.");
        System.out.println("expectedData = " + expectedData);

        Response response=given().spec(spec).when().get("/{first}/{second}");
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
