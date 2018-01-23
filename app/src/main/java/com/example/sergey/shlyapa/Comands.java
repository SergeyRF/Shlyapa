package com.example.sergey.shlyapa;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sergey on 1/14/18.
 */

public class Comands {

    private int bal = 0;
    String name;
    List<Gamer> coma;

    private static Comands[] comands = new Comands[] {new Comands("Olejki"), new Comands("Ashotiki")};

    public static Comands[] getComands() {
        return comands;
    }


    private Comands(String name) {
        this.name=name;
    }
    private void setComa(List<Gamer>coma){
        this.coma=coma;
    }

    public String getName(){
        return name;
    }
    public void setComands(List<Gamer> gamer){
        for(int i=0; i<gamer.size(); i++){
            Gamer g = gamer.get(i);

        }
    }


    public int getBal(){
        return bal;
    }
    public void plusBal(){
        bal += 1;
    }
    public  void minusBal(){bal-=1;}
}
