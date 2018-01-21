package com.example.sergey.shlyapa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 1/14/18.
 */
//Создание Имени
public class PeopleProvider {
    private static int wordsperson;
    List<String> names = new ArrayList<>();
    public void name(String name) {
        names.add(name);
    }
    static List<Gamer> gamer = new ArrayList<>();



    public static void setGamer(String string){
        Gamer i =new Gamer();
        i.setName(string);
        gamer.add(i);

    }
    public static void setWordsperson(int i ){
        wordsperson = i;
    }
    public int getWordsperson(){
        return wordsperson;
    }

  public static List<Gamer> getGamer(){

        return gamer;
 }



}
