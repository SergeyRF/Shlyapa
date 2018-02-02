package com.example.sergey.shlyapa.game;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 1/14/18.
 */

public class Comands {

    private int bal = 0;
    private String name;
    private List<Gamer> coma=new ArrayList<>();
    int n=0;

    public Comands(String name) {
        this.name=name;
    }

    public void setGamer(Gamer com){
        coma.add(com);
    }

    public String getName(){
        return name;
    }
    public int getBal(){
        return bal;
    }
    public void plusBal(int i){
        bal +=i;
    }
    public String getGamer(){
        if(n==coma.size()){
            n=0;
        }
        return coma.get(++n).getName();
    }
}
