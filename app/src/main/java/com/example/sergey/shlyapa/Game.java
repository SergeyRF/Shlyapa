package com.example.sergey.shlyapa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 1/14/18.
 */
// Всё для игры берем отсюда
public class Game {
    final private ArrayList<String> gShlypa = new ArrayList<>();
    private List<Round> rounds = new ArrayList<>();
    private int command;
    private int time;
    private int word;
    private int round;
    private static int i;

    public List getWords(){
        List<String> word = new ArrayList<>();
        for(int i=0; i<30; i++){
            word.add("Хуепутало"+i);
        }
        return word;
    }
    public String getNextWord(){
        i++;
        return "Shlyapa"+i;
    }

    public Game() {
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
