package com.example.sergey.shlyapa.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sergey.shlyapa.Config;
import com.example.sergey.shlyapa.game.Game;
import com.example.sergey.shlyapa.game.Gamer;
import com.example.sergey.shlyapa.R;
import com.example.sergey.shlyapa.ResAdapter;

import java.util.List;

public class PeopleActivity extends AppCompatActivity {

    Button button;
    EditText edit;
    FloatingActionButton fAB;
    List<Gamer> gamers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        fAB = findViewById(R.id.fAB);
        button = findViewById(R.id.next);
        gamers = Game.getInstance().getGamers();
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ResAdapter adapter = new ResAdapter();
        EditText name = findViewById(R.id.name);

        //Добавляем левых людей, если это указано в Config
        if (Config.USE_FAKE_PEOPLES) {
            for(int i = 0; i < 10; i++) {
                gamers.add(new Gamer("Ashot " + i));
            }
        }

        fAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!name.getText().toString().isEmpty()) {
                    Game.getInstance().newGamers(name.getText().toString());
                    name.setText(null);
                }
                adapter.setAdPeople(Game.getInstance().getGamers());
                rv.setAdapter(adapter);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Game.getInstance().getGamers().size()<4){
                    Toast.makeText(PeopleActivity.this,"Мало Людей",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(PeopleActivity.this, ConditionsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
