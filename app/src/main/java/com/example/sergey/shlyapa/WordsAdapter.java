package com.example.sergey.shlyapa;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sergey.shlyapa.game.Game;
import com.example.sergey.shlyapa.game.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 2/2/18.
 */

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.Holder> {

    List<Word> words = new ArrayList<>();


    @Override
    public WordsAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_words, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(WordsAdapter.Holder holder, int position) {
        holder.bind(words.get(position).getWord());
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public void setWord(List<Word> w) {
       words=w;
       notifyDataSetChanged();
    }

    static class Holder extends RecyclerView.ViewHolder {
        public static final String TAG = Holder.class.getSimpleName();
        private TextView word;

        public Holder(View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.int_word);
        }

        public void bind(String string) {
            word.setText(string);
            Log.d(TAG, "bind: " + string);
        }
    }
}
