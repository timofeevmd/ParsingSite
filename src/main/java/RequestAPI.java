import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class RequestAPI {

    public Response parametrizeGetRequest(String getRequest) {
        return given().accept(ContentType.JSON).contentType(ContentType.JSON).when().get(getRequest);
    }

    public Response parametrizePostRequest(String postRequest) {
        return given().accept(ContentType.JSON).contentType(ContentType.JSON).when().post(postRequest);
    }

    public void verifyStatusCode(Response response, int expectedStatusCode) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, expectedStatusCode, "Returns status code: " + statusCode + " instead of: " + expectedStatusCode);
    }

    public int convertStringPropertyToInt(String intProperty) {
        return Integer.parseInt(intProperty);
    }

}
