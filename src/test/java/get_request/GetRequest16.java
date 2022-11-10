package get_request;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class GetRequest16 extends DummyRestApiBaseUrl {

    /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770

               Given
                    URL: https://dummy.restapiexample.com/api/v1/employees
               When
                    User sends get request
               Then
                    Status code is 200
               And
                    There are 24 employees
               And
                    "Tiger Nixon" and "Garrett Winters" are among the employees
               And
                    The greatest age is 66
               And
                    The name of the lowest age is "Tatyana Fitzpatrick"
                And
                    Total salary of all employees is 6,644,770


    */


    @Test
    public void get16() {


        //set the url
        spec.pathParam("first", "employees");

        //set the expected data

        //send the request and get the respose
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //Do assertion
        response.then().assertThat().body("data.id", hasSize(24),
                "data.employee_name", hasItems("Tiger Nixon", "Garrett Winters"));

        //The greatest age is 66
        List<Integer> ages = response.jsonPath().getList("data.employee_age");
        System.out.println("Ages: " + ages);
        Collections.sort(ages);
        System.out.println("Sorted Ages: " + ages);
        System.out.println(ages.get(ages.size() - 1));
        assertEquals(66, (int) (ages.get(ages.size() - 1)));

        //The name of the lowest age is "Tatyana Fitzpatrick"

        String lowestAgedEmployee = response.jsonPath().getString("data.findAll{it.employee_age == " + ages.get(0) + "}.employee_name");
        System.out.println("lowestAgedEmployee = " + lowestAgedEmployee);

        assertEquals("[Tatyana Fitzpatrick]", lowestAgedEmployee);

        //Total salary of all employees is 6,644,770
        List<Integer> salaries = response.jsonPath().getList("data.employee_salary");
        System.out.println("salaries = " + salaries);

        //1. Yol
        int sum = 0;
        for (int w : salaries) {

            sum += w;

        }
        System.out.println("sum = " + sum);

        assertEquals(6644770, sum);

        //2. Yol
        int sum2 = salaries.stream().reduce(0, Integer::sum);
        System.out.println("sum2 = " + sum2);
        assertEquals(6644770, sum2);

        //3. Yol
        int sum3 = salaries.stream().reduce(0, Math::addExact);
        System.out.println("sum3 = " + sum3);
        assertEquals(6644770, sum3);

    }
}
