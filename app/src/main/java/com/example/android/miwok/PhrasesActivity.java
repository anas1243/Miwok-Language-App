package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PhrasesActivity extends AppCompatActivity {

    ArrayList<Word> words = new ArrayList<>(
            Arrays.asList(new Word("minto wuksus", "Where are you going?"),
                    new Word("tinnә oyaase'nә", "What is your name?"),
                    new Word("oyaaset...", "My name is..."),
                    new Word("michәksәs?", "How are you feeling?"),
                    new Word("kuchi achit", "I’m feeling good."),
                    new Word("әәnәs'aa?", "Are you coming?"),
                    new Word("hәә’ әәnәm", "Yes, I’m coming."),
                    new Word("әәnәm", "I’m coming."),
                    new Word("yoowutis", "Let’s go."),
                    new Word("әnni'nem", "Come here.")
            ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }
}
