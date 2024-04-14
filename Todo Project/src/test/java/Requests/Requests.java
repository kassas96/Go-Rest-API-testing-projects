package Requests;

import Models.CreateRequestModel;
import Models.CteateResponseModel;
import Utilities.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Requests {

    public static Response createTodo(CreateRequestModel reqBody) {
       /* int user_id =6265171;
        String title="test";
        String due_on ="2024-02-20T00:00:00.000+05:30";
        String status= "pending";

        */
        // CreateRequestModel reqBody=new CreateRequestModel(6265171,"test","2024-02-20T00:00:00.000+05:30","pending");

        return RestAssured.given().log().all().headers(Constants.getHeaders()).body(reqBody)
                .when().post(Constants.baseUrl + Constants.endpoint);
    }

    public static CteateResponseModel createUserUsingPojo(CreateRequestModel reqBody){
        return RestAssured.given().log().all().headers(Constants.getHeaders()).body(reqBody)
                .when().post(Constants.baseUrl+Constants.endpoint).then().statusCode(201).extract().as(CteateResponseModel.class);
    }

    public static Response getTodo(String id) {
        return RestAssured.given().log().all().headers(Constants.getHeaders())
                .when().get(Constants.baseUrl + Constants.endpoint + id);
    }

    public static Response deleteTodo(String id){
       return RestAssured.given().log().all().headers(Constants.getHeaders())
                .when().delete(Constants.baseUrl+Constants.endpoint+id);
    }
}