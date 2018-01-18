package com.example.sergey.shlyapa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameActyvity extends AppCompatActivity {

    private TextView tvWord;
    private CardView cvWord;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvWord = findViewById(R.id.tv_word);
        cvWord = findViewById(R.id.cv_word);

        game = new Game();

        tvWord.setText(game.getNextWord());
        cvWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cvWord.setOnTouchListener(new OnSwipeTouchListener() {
            @Override
            public boolean onSwipeLeft() {
                Toast.makeText(GameActyvity.this, "Swipe left", Toast.LENGTH_LONG).show();
                return true;
            }

            @Override
            public boolean onSwipeRight() {
                Toast.makeText(GameActyvity.this, "Swipe right", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
}
