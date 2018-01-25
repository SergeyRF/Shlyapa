package com.example.sergey.shlyapa;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sergey.shlyapa.game.Comands;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sergey on 1/17/18.
 */

public class ResAdapCom extends RecyclerView.Adapter<ResAdapCom.Holder>
{

        List<Comands> comands = new ArrayList<>();

    @Override
        public com.example.sergey.shlyapa.ResAdapCom.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.for_holder, parent, false);
            return new com.example.sergey.shlyapa.ResAdapCom.Holder(view);

        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.bind(comands.get(position));
        }

        @Override
        public int getItemCount() {
            return comands.size();
        }
        public void setComands (List<Comands> comandsss){
            comands = comandsss;
            notifyDataSetChanged();
        }

        class Holder extends RecyclerView.ViewHolder{

            private TextView name;
            private TextView ball;
            public Holder(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                ball=itemView.findViewById(R.id.ball);
            }
            public void bind(Comands com){

                name.setText(com.getName());
                ball.setText(String.valueOf(com.getBal()));

            }

        }
    }


