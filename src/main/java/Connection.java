import io.restassured.RestAssured;

import java.util.Properties;

public class Connection extends RequestAPI {
    ConnectionProperties cp = new ConnectionProperties();
    Properties property = cp.parsingPropertyFile();
    public String baseURL = property.getProperty("apiURL");
    public String apiPort = property.getProperty("apiPort");

    public void apiConnection() {
        RestAssured.baseURI = baseURL;
        RestAssured.port = convertStringPropertyToInt(apiPort);
    }
}
