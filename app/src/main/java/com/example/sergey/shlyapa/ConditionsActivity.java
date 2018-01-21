package com.example.sergey.shlyapa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class ConditionsActivity extends AppCompatActivity {
    TextView zna;
    Button button;
    TextView znach;
    TextView znache;
    private int time;
    private int comand;
    private int words;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditions);
        button = findViewById(R.id.button1);
        zna = findViewById(R.id.zna);
        znach = findViewById(R.id.znach);
        znache = findViewById(R.id.znache);
        final SeekBar comande = findViewById(R.id.comande);
        comande.setMax((PeopleProvider.getGamer().size())/2-2);
        comande.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                znache.setText((comande.getProgress()+2)+"");
                comand = comande.getProgress()+2;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final SeekBar word = findViewById(R.id.word);
        word.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                znach.setText((word.getProgress()+5) + "");
                words = word.getProgress()+5;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
       final SeekBar seek = findViewById(R.id.seek);
       seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               zna.setText(String.valueOf(seek.getProgress()+30));
               time = seek.getProgress()+30;
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {


           }
       });
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Game.getInstance().setTime(time);
               Game.getInstance().setCommand(comand);
               PeopleProvider.setWordsperson(words);
               Intent intent =new Intent(ConditionsActivity.this,RoundActivity.class);
               startActivity(intent);
           }
       });



    }

}

