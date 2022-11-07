package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyRestApiBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp() throws Exception {
        spec=new RequestSpecBuilder().setBaseUri(" https://dummy.restapiexample.com/api/v1").build();
    }
}
