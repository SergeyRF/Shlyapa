package com.example.sergey.shlyapa.game;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by alex on 1/18/18.
 */

public class Shlyapa {

    public static final String TAG = Shlyapa.class.getSimpleName();

    private List<Word> words = new ArrayList<>();
    private List<Word> roudWords=new ArrayList<>();
    private int number = -1;

     Shlyapa() {
        words = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            words.add(new Word("Хуепутало" + i));
        }
    }

    void createNewShlyapa() {
        Log.d(TAG, "createNewShlyapa: ");
        roudWords = new ArrayList<>(words);
        number = 0;
    }

    void setShlyapa(List<Word> w){
        for(int i=0;i<w.size();i++){
            words.add(new Word(w.get(i).getWord()));
        }
    }

    /*public String getNextWord1(){
        if(roudWords.size() <= number) return null;
        return roudWords.get(number++);

    }*/
    void rafleShaffle() {
        Collections.shuffle(roudWords);
        number = 0;
    }

    public int delwords() {
        ListIterator<Word> b = roudWords.listIterator();
        int i =0;
        while (b.hasNext()) {
           Word a= b.next();
            if (a.getDel()) {
                if(a.getTrOFl()){
                    i++;
                }
                else i--;
                b.remove();
            }
        }
        return i;
    }

   public   List<Word> getWordsGame() {
        List<Word> w = new ArrayList<>();
        ListIterator<Word> b = roudWords.listIterator();
        while (b.hasNext()) {
            Word next = b.next();
            if (next.getGame()) {
                w.add(next);
            }
        }
        return w;
    }
    boolean getHasWord(){
        if(roudWords.size()==0){

            return false;
        }
        else return true;
    }

    public Word getNextWord() {
        number++;
        Log.d(TAG, "getNextWord: number " + number + " size " + roudWords.size());
        if (roudWords.size() <= number) {
            Log.d(TAG, "getNextWord: null");
            return null;
        }
        Log.d(TAG, "getNextWord: ");
        return roudWords.get(number);
    }

     List<Word> getWords() {
        return words;
    }
}
