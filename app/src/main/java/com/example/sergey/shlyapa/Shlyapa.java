package com.example.sergey.shlyapa;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by alex on 1/18/18.
 */

public class
Shlyapa {

    public static final String TAG = Shlyapa.class.getSimpleName();

    private List<Word> words;
    private List<Word> roudWords;
    private int number = 0;

    public Shlyapa() {
        words = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            words.add(new Word("Хуепутало" + i, i));
        }
    }

    public void createNewShlyapa() {
        roudWords = words;
    }

    /*public String getNextWord1(){
        if(roudWords.size() <= number) return null;
        return roudWords.get(number++);

    }*/
    public void rafleShaffle() {
        Collections.shuffle(roudWords);
    }

    public void delwords() {
        ListIterator<Word> b = roudWords.listIterator();
        while (b.hasNext()) {
            if (b.next().getDel()) {

                b.remove();
            }
        }
    }

    public List<Word> getWordsGame() {
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

    public Word getNextWord() {

        Log.d(TAG, "getNextWord: ");
        if (roudWords.size() <= number) {
            return null;
        }
        return roudWords.get(number++);
    }

    public List<Word> getWords() {
        return words;
    }
}
