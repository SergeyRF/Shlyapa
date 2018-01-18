package com.example.sergey.shlyapa;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 1/16/18.
 */
//адаптер для отображения водщимых людишек
public class ResAdapter extends RecyclerView.Adapter<ResAdapter.Holder> {

    List<Gamer> adPeople = new ArrayList<>();

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.for_holder, parent, false);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind(adPeople.get(position));
    }

    @Override
    public int getItemCount() {
        return adPeople.size();
    }
    public void setAdPeople(List<Gamer> gamers){
        adPeople = gamers;
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder{

        private TextView name;

        public Holder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
        }
        public void bind(Gamer gamer){
            name.setText(gamer.getName());

        }


    }
}
