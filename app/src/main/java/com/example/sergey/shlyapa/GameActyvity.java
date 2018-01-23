package com.example.sergey.shlyapa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameActyvity extends AppCompatActivity {

    private TextView tvWord;
    private TextView tvTime;
    private CardView cvWord;
    private Game game;
    private Shlyapa shlyapa;
    private Word currentword;


    private int timeLeft;
    private boolean started;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvWord = findViewById(R.id.tv_word);
        tvTime = findViewById(R.id.tv_timer);
        cvWord = findViewById(R.id.cv_word);

        game = Game.getInstance();
        shlyapa = game.getShlyapa();
        timeLeft = game.getTime();
        shlyapa.createNewShlyapa();
        currentword = shlyapa.getNextWord();
        tvWord.setText(currentword.getWord());
        cvWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cvWord.setOnTouchListener(new OnSwipeTouchListener() {
            @Override
            public boolean onSwipeLeft() {
                currentword.setTrOfl(false);
                currentword.setGame();
                currentword = shlyapa.getNextWord();
                if (currentword.getWord() != null) {
                    tvWord.setText(currentword.getWord());
                } else {
                    finishRound();
                }
                return true;
            }

            @Override
            public boolean onSwipeRight() {
                currentword.setTrOfl(true);
                currentword.setGame();
                currentword = shlyapa.getNextWord();
                if (currentword.getWord() != null) {
                    tvWord.setText(currentword.getWord());
                } else {
                    finishRound();
                }
                return true;
            }
        });

        //обновляет текст с таймером раз в секунду, если время закончилось, то завершает раунд
        started = true;
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (!started) return;
                if (timeLeft <= 0) {
                    finishRound();
                    return;
                }
                int sec = timeLeft % 60;
                int min = timeLeft / 60;
                String timeString = String.format("%02d:%02d", min, sec);
                tvTime.setText(timeString);

                timeLeft--;
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        started = false;
    }

    /**
     * Завершает работу активити и запускает активити с результатами раунда.
     */
    private void finishRound() {
        finish();
        Intent intent = new Intent(this, RoundFinishActivity.class);
        startActivity(intent);
    }

}
