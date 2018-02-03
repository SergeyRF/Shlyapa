package com.example.sergey.shlyapa.game;

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
    private static int i;
    private Shlyapa shlyapa;
    private List<Word> wordround = new ArrayList<>();
    private List<Comands> comands = new ArrayList<>();
    private List<Gamer> gamers = new ArrayList<>();
    private int wordsperson;
    private int command;
    private int time = 20;
    private int word;
    private int round;
    private int numberComand = 0;
    private int gamerNumber=0;
    private List<String> nameComand = new ArrayList<>();

    private Game() {
        shlyapa = new Shlyapa();
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public int getWordsperson() {
        return wordsperson;
    }

    public void setWordsperson(int i) {
        wordsperson = i;
    }

    public List<Gamer> getGamers() {
        return gamers;
    }
    public boolean hasNextGamer(){
        if(gamers.size()<=gamerNumber+1){
            return false;
        }
        return true;
    }
    public String getTrueGamer(){
        return gamers.get(gamerNumber).getName();
    }
    public String nextGamer(){
        gamerNumber++;
        return gamers.get(gamerNumber).getName();
    }

    public void newGamers(String gamer) {
        gamers.add(new Gamer(gamer));
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

    public Comands getComandGame() {
        return comands.get(numberComand);
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

    public boolean hasNextTurn() {
        return shlyapa.getHasWord();
    }

    public void nextTurn() {
        comands.get(numberComand).plusBal(shlyapa.delwords());
        if (numberComand == comands.size()) {
            numberComand = -1;
        }
        shlyapa.rafleShaffle();
        numberComand++;
    }

    public boolean hasNextRound(){
        return Round.hasRound();
    }

    public void nextRound(){
        Round r = new Round();
        r.nextRound();
        shlyapa.createNewShlyapa();
    }
    public String rulesRound(){
        Round r = new Round();
        return r.getRules();
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
    public void raffleShaffle(){
        shlyapa.rafleShaffle();
    }
    public void newShlyapa(){
        shlyapa.createNewShlyapa();
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }
    public void setSHLYAPA(List<Word> w){
        shlyapa.setShlyapa(w);
    }


}
