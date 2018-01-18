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
    private Shlyapa shlyapa;
    private int command;
    private int time = 60;
    private int word;
    private int round;
    private static int i;

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public List getWords() {
        return shlyapa.getWords();
    }

    public Shlyapa getShlyapa() {
        return shlyapa;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getCommand() {
        return command;
    }

    public String getNextWord() {
        i++;
        return "Shlyapa" + i;
    }

    private Game() {
        for (int a = 0; a < 3; a++) {
            rounds.add(new Round("Hui nani " + a));
        }

        shlyapa = new Shlyapa();
    }

    public Round getNextRound() {
        round++;
        if (round < rounds.size()) {
            return rounds.get(round);
        }
        return null;
    }
}
