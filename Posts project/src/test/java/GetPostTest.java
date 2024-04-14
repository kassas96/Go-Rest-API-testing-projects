import Requests.PostRequest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetPostTest {

    String id="";
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
        public void getPost (){

        Response response= PostRequest.getSinglePost(id);
        response.then().statusCode(200);
        Assert.assertNotNull(response.jsonPath().getString("id"),"the id is null");
        Assert.assertEquals(response.jsonPath().getString("id"),id,"the id is not correct");
    }

    @AfterClass
        public void deletePost(){
            PostRequest.deleteSinglePost(id);
    }





}
