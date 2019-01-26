package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorsActivity extends AppCompatActivity {

    ArrayList<Word> words = new ArrayList<>(
            Arrays.asList(new Word("weṭeṭṭi","red",R.drawable.color_red),
                    new Word("chokokki","green",R.drawable.color_green),
                    new Word("ṭakaakki","brown",R.drawable.color_brown),
                    new Word("ṭopoppi","gray",R.drawable.color_gray),
                    new Word("kululli","black",R.drawable.color_black),
                    new Word("kelelli","white",R.drawable.color_white),
                    new Word("ṭopiisә","dusty yellow",R.drawable.color_dusty_yellow),
                    new Word("chiwiiṭә","mustard yellow",R.drawable.color_mustard_yellow)
            ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }
}
