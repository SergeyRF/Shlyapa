package com.example.sergey.shlyapa.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sergey.shlyapa.game.Game;
import com.example.sergey.shlyapa.R;
import com.example.sergey.shlyapa.ResAdapCom;

public class RoundActivity extends AppCompatActivity {
    Button button;
    TextView roundconfig;
    TextView gName;
    TextView gComand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        roundconfig = findViewById(R.id.roundconfig);
        gName = findViewById(R.id.gname);
        gComand = findViewById(R.id.gcomand);
        if( Game.getInstance().hasNextTurn()){
            Game.getInstance().nextTurn();
        }
        else {
            if(Game.getInstance().hasNextRound())
            {
                Game.getInstance().nextTurn();
            }
            else {// Переход на финишную страницу.
                 }
        }
        RecyclerView recyclerView = findViewById(R.id.rev);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ResAdapCom rac = new ResAdapCom();
        rac.setComands(Game.getInstance().getComands());
        recyclerView.setAdapter(rac);

        button = findViewById(R.id.game);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RoundActivity.this, GameActyvity.class);

                startActivity(intent);
            }
        });

    }
}
