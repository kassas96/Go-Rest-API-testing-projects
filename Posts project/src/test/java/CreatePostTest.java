import Requests.PostRequest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreatePostTest {

    @Test
    public void createPost() {
        String user_id = "6204965";
        String title = "test title";
        String body = "test body mdkldmslml mdmslkm'[as;l";

        Response response = PostRequest.createPost (user_id, title, body);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        String id = jsonPath.get("id").toString();

        //test assertions
        SoftAssert softAssert=new SoftAssert();
        response.then().statusCode(201);
        softAssert.assertEquals(jsonPath.get("user_id").toString(),user_id,"the user_id is not correct");
        softAssert.assertEquals(jsonPath.get("title").toString(),title,"the title is not correct");
        softAssert.assertEquals(jsonPath.get("body").toString(),body,"the body is not correct");

        PostRequest.deleteSinglePost(id);
        softAssert.assertAll();
    }

    @Test
        public void createWithMissingField (){
        String user_id = "6204965";

        String body = "test body mdkldmslml mdmslkm'[as;l";

        Response response = PostRequest.createWithMissingTitleField(user_id, body);
        response.prettyPrint();
        JsonPath jsonPath= response.jsonPath();

        response.then().statusCode(422);

    }

    @Test
    public void validateNotBlank (){
        String user_id = "    ";
        String title = "   ";
        String body = "   ";

        Response response = PostRequest.createPost(user_id, title, body);
        response.prettyPrint();
        JsonPath jsonPath= response.jsonPath();


        response.then().statusCode(401);
        SoftAssert softAssert= new SoftAssert();

        Object userIdValue = jsonPath.get("user_id");   //we assign the value returned by jsonPath.get() to an Object variable (userIdValue, titleValue, bodyValue) instead of directly invoking toString() on it.
        softAssert.assertNull(userIdValue, "the <user_id> is blank");   //Then, we pass the Object variables to the softAssert.assertNull() method for assertion.

        Object titleValue = jsonPath.get("title");
        softAssert.assertNull(titleValue, "the <title> is blank");

        Object bodyValue = jsonPath.get("body");
        softAssert.assertNull(bodyValue, "the <body> is blank");



        softAssert.assertAll();
    }
}