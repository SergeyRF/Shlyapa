package com.example.sergey.shlyapa;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sergey on 1/14/18.
 */

public class Comands {

    private int bal = 0;
    private String name;
    private List<Gamer> coma;

    public Comands(String name) {
        this.name=name;
    }

    public void setGamer(Gamer com){
        this.coma.add(com);
    }

    public String getName(){
        return name;
    }

    public void reBal(){

    }


    public int getBal(){
        return bal;
    }
    public void plusBal(){
        bal += 1;
    }
    public  void minusBal(){bal-=1;}
}
