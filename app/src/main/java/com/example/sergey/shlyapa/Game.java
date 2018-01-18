package com.example.sergey.shlyapa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 1/14/18.
 */
// Всё для игры берем отсюда
public class Game {

    private static Game instance;

    final private ArrayList<String> gShlypa = new ArrayList<>();
    private List<Round> rounds = new ArrayList<>();
    private int command;
    private int time;
    private int word;
    private int round;
    private static int i;

    public static Game getInstance() {
        if(instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public List getWords(){
        List<String> word = new ArrayList<>();
        for(int i=0; i<30; i++){
            word.add("Хуепутало"+i);
        }
        return word;
    }

    public void setTime(int time){
        this.time=time;
    }
    public int getTime(){
        return time;
    }
    public void setCommand(int command){
        this.command=command;
    }
    public int getCommand(){
        return command;
    }
    public String getNextWord(){
        i++;
        return "Shlyapa"+i;
    }

    private Game() {
        for(int a = 0; a < 3; a++) {
            rounds.add(new Round("Hui nani " + a));
        }
    }

    public Round getNextRound() {
        round++;
        if(round < rounds.size()) {
            return rounds.get(round);
        }
        return null;
    }
}
