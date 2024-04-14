import Requests.PostRequest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeletePostTest {

    String id ="";

    @BeforeClass

        public void preconditions(){
            String user_id = "6204965";
            String title = "test title";
            String body = "test body mdkldmslml mdmslkm'[as;l";

            Response response = PostRequest.createPost(user_id, title, body);
            response.prettyPrint();
            JsonPath jsonPath = response.jsonPath();

            id= jsonPath.getString("id");
    }

    @Test
        public void deletePost(){
            PostRequest.deleteSinglePost(id);
        Response response= PostRequest.getSinglePost(id);
        //Assert.assertNotNull(response.jsonPath().getString("id"),"the id is null");
        Assert.assertNull(response.jsonPath().getString("id"),"the id is null");
    }
}
