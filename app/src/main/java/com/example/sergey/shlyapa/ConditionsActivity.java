package com.example.sergey.shlyapa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class ConditionsActivity extends AppCompatActivity {
    TextView zna;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditions);

        zna = findViewById(R.id.zna);
       final SeekBar seek = findViewById(R.id.seek);
       seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               zna.setText(String.valueOf(seek.getProgress()+30));
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {


           }
       });


    }

}

