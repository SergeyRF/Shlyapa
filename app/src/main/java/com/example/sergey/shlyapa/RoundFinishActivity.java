package com.example.sergey.shlyapa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class RoundFinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_finish);
        ResAdaptFinish finish = new ResAdaptFinish();
        RecyclerView rv = findViewById(R.id.fin);
        finish.setWords(Game.getInstance().getShlyapa().getWordsGame());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(finish);
        //dfdfdf
    }
}
