package com.example.sergey.shlyapa.game;

/**
 * Created by sergey on 1/14/18.
 */
//Создание активного игрока
public class Gamer {
     private String name;
     private long id;
     static long idd;


    public Gamer(String string) {
        name = string;

        id = idd;
        idd++;
    }

    public void setName (String string){
        name = string;
    }
    public String getName(){
        return name;
    }

}
