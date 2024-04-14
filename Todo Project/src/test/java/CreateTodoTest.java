import Models.CreateRequestModel;
import Models.CteateResponseModel;
import Requests.Requests;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateTodoTest {

    @Test
    public void createTest(){
        CreateRequestModel req =new CreateRequestModel(6265171,"test","2024-02-20T00:00:00.000+05:30","pending");

        Response response= Requests.createTodo(req);
        JsonPath jsonPath=response.jsonPath();
        response.prettyPrint();

        response.then().statusCode(201);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertNotNull("id","the id is null");
        softAssert.assertEquals(jsonPath.getString("status"),"pending","the status not correct");

        Requests.deleteTodo(jsonPath.get("id").toString());
        softAssert.assertAll();

    }
    @Test
    public void createTestPojo(){
        CreateRequestModel req =new CreateRequestModel(6265171,"test","2024-02-20T00:00:00.000+05:30","pending");

        CteateResponseModel res=Requests.createUserUsingPojo(req); //status code assertion is done while creating as then() is called while create function is operating

        Assert.assertEquals(res.title,"test","title is not the same");

        Requests.deleteTodo(res.id);
    }
}
