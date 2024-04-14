import Requests.PostRequest;
import Utilities.Constants;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UpdatePostTest {

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
    public void updatePost (){


       String title = "test ";
        String body = "test body ";

        Response response= RestAssured.given().log().all().headers(Constants.getHeaders())
                .body(" {\n" +
                        "         \"title\": \""+title+"\",\n" +

                        "        \"body\": \""+body+"\"\n" +
                        "    }").put(Constants.baseUrl+Constants.endPoint+id);



        response.then().statusCode(200);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertNotNull(response.jsonPath().getString("title"),"the title is null");
        softAssert.assertEquals(response.jsonPath().getString("title"),title,"the user_id is not correct");

        softAssert.assertNotNull(response.jsonPath().getString("body"),"the body is null");
        softAssert.assertEquals(response.jsonPath().getString("body"),body,"the body is not correct");
        softAssert.assertAll();
    }

    @AfterClass
    public void deletePost(){
        PostRequest.deleteSinglePost(id);
    }
}
