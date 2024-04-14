package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        //serialization
        ObjectMapper mapper= new ObjectMapper();
        Player player=new Player("medo",25,"10");
        String jsonPlayer=mapper.writeValueAsString(player);

        System.out.println(jsonPlayer);

     //Deserialization
        Player player2=mapper.readValue(jsonPlayer, Player.class);
        player2.name="zezo";
        player2.age=20;
        player2.number="3";

        System.out.println(player2.name);
        System.out.println(player2.age);
        System.out.println(player2.number);

    }
}

class Player{
    public Player(){

    }
    public Player(String name, int age, String number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public String name;
    public int age ;
    public String number;

}