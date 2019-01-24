package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    ArrayList<Word> words = new ArrayList<>(
            Arrays.asList(new Word("lutti","one"),
                    new Word("otiiko","two"),
                    new Word("tolookosu","three"),
                    new Word("oyyisa","four"),
                    new Word("massokka","five"),
                    new Word("temmokka","six"),
                    new Word("kenekaku","seven"),
                    new Word("kawinta","eight"),
                    new Word("wo’e","nine"),
                    new Word("na’aacha","ten")
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
