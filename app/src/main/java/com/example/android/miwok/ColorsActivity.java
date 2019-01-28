package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorsActivity extends AppCompatActivity {

    private int audioID;
    private MediaPlayer mediaPlayer;

    ArrayList<Word> words = new ArrayList<>(
            Arrays.asList(new Word("weṭeṭṭi", "red",
                            R.drawable.color_red, R.raw.color_red),
                    new Word("chokokki", "green",
                            R.drawable.color_green, R.raw.color_green),
                    new Word("ṭakaakki", "brown",
                            R.drawable.color_brown, R.raw.color_brown),
                    new Word("ṭopoppi", "gray",
                            R.drawable.color_gray, R.raw.color_gray),
                    new Word("kululli", "black",
                            R.drawable.color_black, R.raw.color_black),
                    new Word("kelelli", "white",
                            R.drawable.color_white, R.raw.color_white),
                    new Word("ṭopiisә", "dusty yellow",
                            R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow),
                    new Word("chiwiiṭә", "mustard yellow",
                            R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow)
            ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_colors);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                audioID = words.get(position).getAudioResorceId();
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, audioID);
                mediaPlayer.start();
            }
        });

    }
}
