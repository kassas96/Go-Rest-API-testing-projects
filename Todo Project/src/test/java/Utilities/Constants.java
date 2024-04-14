package Utilities;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Constants {
   public static String baseUrl="https://gorest.co.in/public/v2";
    public static String endpoint="/todos/";


    public static Map<String,String> getHeaders(){
        Map<String,String> headerss= new HashMap<>();


        headerss.put("Authorization","Bearer 16487efbe48167ab86a20fdb5b9724a3086fd8e181c263bb2c70b6a4073203e2");
        headerss.put("Content-Type","application/json");
        return headerss;
    }




}
