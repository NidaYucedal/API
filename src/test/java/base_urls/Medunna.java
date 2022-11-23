package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utils.Authentication;


public class Medunna extends Authentication {
        protected RequestSpecification spec01;

        @Before
        public void setUp() {
            spec01 = new RequestSpecBuilder().setBaseUri("https://www.medunna.com/api").build();
        }
    }

