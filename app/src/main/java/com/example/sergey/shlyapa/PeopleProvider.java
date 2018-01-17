package com.example.sergey.shlyapa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 1/14/18.
 */
//Создание Имени
public class PeopleProvider {
    List<String> names = new ArrayList<>();
    public void name(String name){
    names.add(name);

    }
    public void rename(){

    }
  public static List<Gamer> getGamer(){
     List<Gamer> gamer = new ArrayList<>();
        for(int i=0,j=12; i<10;i++,j++)
        {
            gamer.add(new Gamer("OLegka"+j));

        }

        return gamer;
 }


}
