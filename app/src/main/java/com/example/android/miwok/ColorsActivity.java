package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorsActivity extends AppCompatActivity {

    ArrayList<Word> words = new ArrayList<>(
            Arrays.asList(new Word("weṭeṭṭi","red"),
                    new Word("chokokki","green"),
                    new Word("ṭakaakki","brown"),
                    new Word("ṭopoppi","gray"),
                    new Word("kululli","black"),
                    new Word("kelelli","white"),
                    new Word("ṭopiisә","dusty yellow"),
                    new Word("chiwiiṭә","mustard yellow")
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
