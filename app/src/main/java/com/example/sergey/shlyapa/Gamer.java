package com.example.sergey.shlyapa;

/**
 * Created by sergey on 1/14/18.
 */
//Создание активного игрока
public class Gamer {
     private String name;
     private long id;
     static long idd;


    public Gamer(String name) {
        this.name = name;
        id = idd;
        idd++;
    }
}
