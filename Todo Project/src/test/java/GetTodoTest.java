import Models.CreateRequestModel;
import Requests.Requests;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetTodoTest {

     String id="";

    @BeforeClass
    public void precondetions(){
        CreateRequestModel req =new CreateRequestModel(6265171,"test","2024-02-20T00:00:00.000+05:30","pending");

        Response response= Requests.createTodo(req);
        JsonPath jsonPath=response.jsonPath();
        id=jsonPath.getString("id");

    }

    @Test
    public void getTodoTest(){
        Response response=Requests.getTodo(id);
        response.then().statusCode(200);
        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals(jsonPath.getString("id"),id,"the id is not correct");

    }

    @AfterClass
    public void deleteTodo(){
       Response response= Requests.deleteTodo(id);
    }

}
