package com.example.sergey.shlyapa;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class RoundFinishActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_finish);
        button = findViewById(R.id.nextt);
        ResAdaptFinish finish = new ResAdaptFinish();
        RecyclerView rv = findViewById(R.id.fin);
        finish.setWords(Game.getInstance().getShlyapa().getWordsGame());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(finish);
        //dfdfdf
        button.setOnClickListener((v) -> startNext());
    }


    private void startNext() {
        //create intent and start activity
Intent intent = new Intent(RoundFinishActivity.this, RoundActivity.class);
Game.getInstance().getShlyapa().delwords();
startActivity(intent);
        // save everything

        //call finish
        finish();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Хуя в рот играйте дальше!", Toast.LENGTH_LONG).show();
    }
}
