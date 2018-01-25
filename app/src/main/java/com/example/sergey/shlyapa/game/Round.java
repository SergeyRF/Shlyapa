package com.example.sergey.shlyapa.game;

/**
 * Created by sergey on 1/14/18.
 */
// Описание Раундов

public class Round {

    private String[] rules=new String[]{"Раунд №1.\n Бей, убивай","Раунд №2.\n Еби гусей","Раунд №3.\n Хуй! Пизда! Джигурда!"};
    private static int n=1;



    public void nextRound(){
        n++;
    }
    public static boolean hasRound(){
        if(n==3){
            return false;
        }
        else return true;
    }
    public String getRules(){
        return rules[n];
    }


}
