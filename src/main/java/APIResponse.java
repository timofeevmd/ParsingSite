import io.restassured.response.Response;
import objects.GetAPIObject;
import objects.PostAPIObject;
import org.testng.Assert;


public class APIResponse extends RequestAPI {
    GetAPIObject[] getObjectArrays;
    PostAPIObject getObjectId;

    public void getPostsUserId(Response response) {
        getObjectArrays = response.getBody().as(GetAPIObject[].class);
        Assert.assertNotNull(getObjectArrays[0].getUserId(), "Object not contain in GET request");
    }

    public void postPostsId(Response response){
        getObjectId = response.getBody().as(PostAPIObject.class);
        Assert.assertNotNull(getObjectId.getId(), "Object not contain in POST request");
    }
}
