package com.example.sergey.shlyapa;

/**
 * Created by sergey on 1/14/18.
 */
//Создание активного игрока
public class Gamer {
     private String name;
     private long id;
     static long idd;


    public Gamer() {

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
