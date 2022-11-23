package post_request;

import base_urls.Medunna;
import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Test;
import pojos.AuthoritiesPojo;
import pojos.ResponsePojo;

import static io.restassured.RestAssured.*;

public class Deneme extends Medunna {
    /*
    {
  "activated": true,
  "authorities": [
    "string"
  ],
  "createdBy": "string",
  "createdDate": "2022-11-21T15:54:55.905Z",
  "email": "string",
  "firstName": "string",
  "imageUrl": "string",
  "langKey": "string",
  "lastModifiedBy": "string",
  "lastModifiedDate": "2022-11-21T15:54:55.905Z",
  "lastName": "string",
  "login": "string",
  "ssn": "string"
}
     */
    @Test
    public void name() {
        //spec01.pathParams("pp1", "users");
        AuthoritiesPojo authorities = new AuthoritiesPojo("string");
        ResponsePojo exData = new ResponsePojo(true, authorities, "tarik45",
                "buBirTa3rihtir", "tarik5@gmail.com", "tarik", "asdf",
                "asdfg", "tarik1" +
                "sffg", "ikinciTarih", "kilickayaaa",
                "tarik4", "436-45-8120");
        Response response = given().contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + generateToken())
                .when().body(exData).post("https://www.medunna.com/api/users");
        response.prettyPrint();
    }


    static Faker faker = new Faker();
    static Response response;
    static ResponsePojo registrant = new ResponsePojo();
     static RequestSpecification spec;

    public static void main(String[] args) throws JsonProcessingException {
        //spec = new RequestSpecBuilder().setBaseUri("https://www.medunna.com/api/").build();
        //spec.pathParams("1", "users");
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String SSN = faker.idNumber().ssnValid();
        registrant.setFirstName(firstname);
        registrant.setLastName(lastname);
        registrant.setSsn(SSN);
        registrant.setLogin(firstname + lastname);
        registrant.setEmail(faker.internet().emailAddress(firstname + lastname));
        response = given().contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + generateToken())
                .when().post("https://www.medunna.com/api/users");
        response.prettyPrint();
        response.then().statusCode(201);
      // ObjectMapper obj = new ObjectMapper();
      // Account actualRegistrant = obj.readValue(response.asString(), Account.class);
      // System.out.println("Actual Data: " + actualRegistrant);
      // Assert.assertEquals(registrant.getFirstName(), actualRegistrant.getFirstName());
      // Assert.assertEquals(registrant.getLastName(), actualRegistrant.getLastName());
      // Assert.assertEquals(registrant.getSsn(), actualRegistrant.getSsn());

    }
}