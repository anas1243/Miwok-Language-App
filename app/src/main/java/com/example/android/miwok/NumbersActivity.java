package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    ArrayList<Word> words = new ArrayList<>(
            Arrays.asList(new Word("lotti","one"),
                    new Word("lotti","two"),
                    new Word("lotti","three"),
                    new Word("lotti","four"),
                    new Word("lotti","five"),
                    new Word("lotti","six"),
                    new Word("lotti","seven"),
                    new Word("lotti","eight"),
                    new Word("lotti","nine"),
                    new Word("lotti","ten")
            ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }
}
