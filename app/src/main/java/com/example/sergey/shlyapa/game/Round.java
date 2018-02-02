package com.example.sergey.shlyapa.game;

/**
 * Created by sergey on 1/14/18.
 */
// Описание Раундов

public class Round {

    private String[] rules=new String[]{" Бей, убивай"," Еби гусей"," Хуй! Пизда! Джигурда!"};
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
    public static String getRoundN(){
        return String.valueOf(n);
    }
    public String getRules(){
        return rules[n];
    }


}
