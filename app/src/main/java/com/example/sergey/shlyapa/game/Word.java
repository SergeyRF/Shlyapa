package com.example.sergey.shlyapa.game;

/**
 * Created by sergey on 1/21/18.
 */

public class Word {
    private String word;
    private int id;
    private boolean del;
    private boolean trOfl;
    private boolean game;
    private static int i=0;



    public Word(String string) {
           word =string;
           id=++i;
    }
    public void setGame(){game=true;}
    public void setNoDel(){game = false;}
    public boolean getGame(){return game;}
  //  public int getId(){
    //    return id;
    //}
    public  String getWord(){return word;}
    public boolean getDel(){return del;}
    public void setDel(){del=true;}
    public void setTrOfl(boolean b){trOfl=b;}
    public  boolean getTrOFl(){return trOfl;}
}
