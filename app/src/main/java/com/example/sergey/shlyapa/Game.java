package com.example.sergey.shlyapa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by sergey on 1/14/18.
 */
// Всё для игры берем отсюда
public class Game {

    private static Game instance;
    private List<Round> rounds = new ArrayList<>();
    private Shlyapa shlyapa;
    private List<Word> wordround = new ArrayList<>();
    private List<Comands> comands = new ArrayList<>();
    private List<Gamer> gamers = new ArrayList<>();
    private int wordsperson;
    private int command;
    private int time = 20;
    private int word;
    private int round;
    private static int i;
    private List<String> nameComand = new ArrayList<>();

    public void setWordsperson(int i) {
        wordsperson = i;
    }

    public int getWordsperson() {
        return wordsperson;
    }

    public List<Gamer> getGamers() {
        return gamers;
    }

    public void newGamers(String gamer) {
        gamers.add(new Gamer(gamer));
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void setComands() {
        nameComand.clear();
        nameComand.add("Gaga");
        nameComand.add("Rape");
        nameComand.add("Poreedge");
        nameComand.add("Comanda");
        nameComand.add("Travmat");
        Collections.shuffle(nameComand);
        List<Comands> c = new ArrayList<>();
        for (int i = 0; i < command; i++) {
            c.add(new Comands(nameComand.get(i)));
        }
        comands = c;
    }

    public List<Comands> getComands() {
        return comands;
    }

    public void setComGamers() {
        ListIterator<Gamer> g = gamers.listIterator();
        while (g.hasNext()) {
            for (Comands c : comands) {
                if (g.hasNext()) {
                    c.setGamer(g.next());
                } else break;

            }

        }
        return;
    }

    public void setword(Word w) {
        wordround.add(w);
    }

    public List<Word> getword() {
        return wordround;
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

    public void finishRound() {
        shlyapa.createNewShlyapa();
    }
}
