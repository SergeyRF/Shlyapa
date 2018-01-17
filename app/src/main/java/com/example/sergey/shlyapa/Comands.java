package com.example.sergey.shlyapa;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sergey on 1/14/18.
 */

public class Comands {

    private int bal;

    private static Comands[] comands = new Comands[] {new Comands("Olejki"), new Comands("Ashotiki")};

    public static Comands[] getComands() {
        return comands;
    }


    private Comands(String name) {

    }
    public int getBal(){
        return bal;
    }
    public void setBal(int i){
        bal = i;
    }
}
