package com.example.sergey.shlyapa;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 1/17/18.
 */

public class ResAdaptFinish extends RecyclerView.Adapter<ResAdaptFinish.Holder> {
    public static final String TAG = ResAdaptFinish.class.getSimpleName();
    List<Word> words=new ArrayList<>();
    @Override
    public com.example.sergey.shlyapa.ResAdaptFinish.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder, parent, false);
        return new com.example.sergey.shlyapa.ResAdaptFinish.Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        holder.bind(words.get(position));

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + words.size());
        return words.size();
    }
    public void setWords(List<Word> w){
        words=w;
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder {
        private CheckBox yes;
        private CheckBox not;
        private CheckBox elsee;
        private TextView word;


        public Holder(View itemView) {
            super(itemView);

            yes = itemView.findViewById(R.id.yes);
            not = itemView.findViewById(R.id.not);
            elsee = itemView.findViewById(R.id.elsee);
            word = itemView.findViewById(R.id.word);


        }

        public void bind(Word w) {
            word.setText(w.getWord());
            if(w.getTrOFl()){yes.setChecked(true); w.setDel();}
            else {not.setChecked(true);w.setDel();}
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //click(v);
                    not.setChecked(false);
                    elsee.setChecked(false);
                    yes.setChecked(true);
                    w.setDel();
                }
            });
            not.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //click(v);
                    yes.setChecked(false);
                    elsee.setChecked(false);
                    not.setChecked(true);
                    w.setDel();
                }
            });
            elsee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //click(v);
                    elsee.setChecked(true);
                    yes.setChecked(false);
                    not.setChecked(false);
                    w.setNoDel();
                }
            });


        }


        }

    }

