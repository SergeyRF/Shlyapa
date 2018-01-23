package com.example.sergey.shlyapa;

/**
 * Created by sergey on 1/21/18.
 */

public class Word {
    private String word;
    private int id;
    private boolean del;
    private boolean trOfl;
    private boolean game;


    public Word(String string, int i) {
           word =string;
           id=i;
    }
    public void setGame(){game=true;}
    public void setNoDel(){game = false;}
    public boolean getGame(){return game;}
    public int getId(){
        return id;
    }
    public  String getWord(){return word;}
    public boolean getDel(){return del;}
    public void setDel(){del=true;}
    public void setTrOfl(boolean b){trOfl=b;}
    public  boolean getTrOFl(){return trOfl;}
}
