package com.example.sergey.shlyapa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class RoundActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        RecyclerView recyclerView = findViewById(R.id.rev);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ResAdapCom rac = new ResAdapCom();
        rac.setComands(Comands.getComands());
        recyclerView.setAdapter(rac);
        button = findViewById(R.id.game);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoundActivity.this,RoundFinishActivity.class);
                startActivity(intent);
            }
        });

    }
}
