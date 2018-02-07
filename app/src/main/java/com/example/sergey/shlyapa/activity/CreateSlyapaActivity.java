package com.example.sergey.shlyapa.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergey.shlyapa.R;
import com.example.sergey.shlyapa.WordsAdapter;
import com.example.sergey.shlyapa.game.Game;
import com.example.sergey.shlyapa.game.Word;

import java.util.ArrayList;
import java.util.List;

public class CreateSlyapaActivity extends AppCompatActivity {

    public static final String TAG = CreateSlyapaActivity.class.getSimpleName();

    TextView gamer;
    EditText wordText;
    RadioButton fuckRB;
    Button button;
    CheckBox random;
    List<Word> wordList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_slyapa);
        RecyclerView rv = findViewById(R.id.wordsSlyapa);
        WordsAdapter wAA = new WordsAdapter();
        wAA.setWord(wordList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(wAA);
        fuckRB=findViewById(R.id.fuckingRoundButton);
        wordText = findViewById(R.id.wordText);
        gamer = findViewById(R.id.gamer);
        button =findViewById(R.id.buttonNext);
        random = findViewById(R.id.random);
        gamer.setText(Game.getInstance().getTrueGamer());
        fuckRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i <= Game.getInstance().getWordsperson()-1;i++){
                    wordList.add(new Word("Пиздец Заебало"+i));
                    wAA.notifyDataSetChanged();}
                if(!wordText.getText().toString().isEmpty()&& wordList.size()!=Game.getInstance().getWordsperson()){
                    Word word = new Word(wordText.getText().toString());
                    Log.d(TAG, "onClick: new word " + word.getWord());
                    wordList.add(new Word(wordText.getText().toString()));
                    wAA.notifyDataSetChanged();

                    wordText.setText("");
               }
               else {
                    Toast.makeText(CreateSlyapaActivity.this, "Уже хватит баловаться", Toast.LENGTH_LONG).show();
                }
            }


        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(wordList.size()==Game.getInstance().getWordsperson()){
                    Game.getInstance().setSHLYAPA(wordList);
                    if(Game.getInstance().hasNextGamer()){
                        wordList.clear();
                        wAA.setWord(wordList);
                        gamer.setText(Game.getInstance().nextGamer());
                    }
                    else {
                        // Переход дальше
                        Game.getInstance().newShlyapa();
                        Intent intent =new Intent(CreateSlyapaActivity.this,RoundActivity.class);
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(CreateSlyapaActivity.this, "Пиши ещё сученька!", Toast.LENGTH_LONG).show();
                }
                }


        });
    }
}
