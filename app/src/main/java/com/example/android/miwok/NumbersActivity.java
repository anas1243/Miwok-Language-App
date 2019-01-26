package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    ArrayList<Word> words = new ArrayList<>(
            Arrays.asList(new Word("lutti","one",R.drawable.number_one),
                    new Word("otiiko","two",R.drawable.number_two),
                    new Word("tolookosu","three",R.drawable.number_three),
                    new Word("oyyisa","four",R.drawable.number_four),
                    new Word("massokka","five",R.drawable.number_five),
                    new Word("temmokka","six",R.drawable.number_six),
                    new Word("kenekaku","seven",R.drawable.number_seven),
                    new Word("kawinta","eight",R.drawable.number_eight),
                    new Word("wo’e","nine",R.drawable.number_nine),
                    new Word("na’aacha","ten",R.drawable.number_ten)
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
