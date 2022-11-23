package utils;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Authentication {
    /*
        public static void main(String[]args){

            String token=generateToken();

           System.out.println("token = " + token);
           }
     */
    public static String generateToken() {

        String username = "Nida";
        String password = "Batch81.";


        Map<String, Object> postBody = new HashMap<>();
        postBody.put("password", password);
        postBody.put("rememberMe", true);
        postBody.put("username", username);

        String endPoint = "https://www.medunna.com/api/authenticate";

        Response response = given().contentType(ContentType.JSON).body(postBody).when().post(endPoint);

        JsonPath token = response.jsonPath();
        return token.getString("id_token");
    }

}