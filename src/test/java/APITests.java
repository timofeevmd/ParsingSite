import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class APITests {
    RequestAPI requestAPI = new RequestAPI();
    Connection connection = new Connection();
    APIResponse APIResponse = new APIResponse();
    ConnectionProperties cp = new ConnectionProperties();
    Properties property = cp.parsingPropertyFile();
    String getRequest = property.getProperty("getRequest");
    String postRequest = property.getProperty("postRequest");


    @BeforeTest
    public void initiateTest() {
        connection.apiConnection();
    }

    @Test
    public void getTest(){
        Response response = requestAPI.parametrizeGetRequest(getRequest);
        requestAPI.verifyStatusCode(response, 200);
        APIResponse.getPostsUserId(response);
    }

    @Test
    public void postTest(){
        Response response = requestAPI.parametrizePostRequest(postRequest);
        requestAPI.verifyStatusCode(response, 201);
        APIResponse.postPostsId(response);
    }
}
