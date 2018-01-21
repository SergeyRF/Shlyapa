package com.example.sergey.shlyapa;

import android.content.Intent;
import android.net.sip.SipSession;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        gamers = PeopleProvider.getGamer();
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ResAdapter adapter = new ResAdapter();
        EditText name = findViewById(R.id.name);



        fAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!name.getText().toString().isEmpty()) {
                    PeopleProvider.setGamer(name.getText().toString());
                    name.setText(null);
                }
                adapter.setAdPeople(PeopleProvider.getGamer());
                rv.setAdapter(adapter);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PeopleActivity.this,ConditionsActivity.class);
                startActivity(intent);
            }
        });
    }
}
