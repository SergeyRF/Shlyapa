package com.example.sergey.shlyapa;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by sergey on 1/17/18.
 */

public class ResAdaptFinish extends RecyclerView.Adapter<ResAdaptFinish.Holder> {
    @Override
    public com.example.sergey.shlyapa.ResAdaptFinish.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder, parent, false);
        return new com.example.sergey.shlyapa.ResAdaptFinish.Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind("fdgf");

    }

    @Override
    public int getItemCount() {
        return 1;
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

        public void bind(String g) {
            word.setText(g);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //click(v);
                    not.setChecked(false);
                    elsee.setChecked(false);
                    yes.setChecked(true);
                }
            });
            not.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //click(v);
                    yes.setChecked(false);
                    elsee.setChecked(false);
                    not.setChecked(true);
                }
            });
            elsee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //click(v);
                    elsee.setChecked(true);
                    yes.setChecked(false);
                    not.setChecked(false);
                }
            });


        }


        }

    }

