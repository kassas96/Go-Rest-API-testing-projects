package Requests;

import Utilities.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostRequest {

    public static Response createPost(String user_id,String title, String body){

        Response response= RestAssured.given().log().all().headers(Constants.getHeaders())
                .body(" {\n" +
                        "        \"user_id\": "+user_id+",\n" +
                        "        \"title\": \""+title+"\",\n" +
                        "        \"body\": \""+body+"\"\n" +
                        "    }").post(Constants.baseUrl+Constants.endPoint);

   return response;
    }

    public static Response createWithMissingTitleField(String user_id, String body){

        Response response= RestAssured.given().log().all().headers(Constants.getHeaders())
                .body(" {\n" +
                        "        \"user_id\": "+user_id+",\n" +

                        "        \"body\": \""+body+"\"\n" +
                        "    }").post(Constants.baseUrl+Constants.endPoint);

        return response;
    }

    public static Response getSinglePost(String id){
        return RestAssured.given().log().all().headers(Constants.getHeaders()).get(Constants.baseUrl+Constants.endPoint+id);
    }

    public static Response deleteSinglePost(String id){

       return RestAssured.given().log().all().headers(Constants.getHeaders()).delete(Constants.baseUrl+Constants.endPoint+id);
    }





}
