package com.example.sergey.shlyapa;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 1/18/18.
 */

public class Shlyapa {
    
    public static final String TAG = Shlyapa.class.getSimpleName();

    private List<String> words;
    private int number = 0;

    public Shlyapa() {
        words = new ArrayList<>();
        for(int i=0; i<10; i++){
            words.add("Хуепутало"+i);
        }
    }

    public String getNextWord() {
        Log.d(TAG, "getNextWord: ");
        if(words.size() <= number) return null;
        return words.get(number++);
    }

    public List<String> getWords() {
        return words;
    }
}
