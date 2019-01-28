package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FamilyActivity extends AppCompatActivity {

    private int audioID;
    private MediaPlayer mediaPlayer;

    ArrayList<Word> words = new ArrayList<>(
            Arrays.asList(new Word("әpә", "father",
                            R.drawable.family_father, R.raw.family_father),
                    new Word("әṭa", "mother",
                            R.drawable.family_mother, R.raw.family_mother),
                    new Word("angsi", "son",
                            R.drawable.family_son, R.raw.family_son),
                    new Word("tune", "daughter",
                            R.drawable.family_daughter, R.raw.family_daughter),
                    new Word("taachi", "older brother",
                            R.drawable.family_older_brother, R.raw.family_older_brother),
                    new Word("chalitti", "younger brother",
                            R.drawable.family_younger_brother, R.raw.family_younger_brother),
                    new Word("teṭe", "older sister",
                            R.drawable.family_older_sister, R.raw.family_older_sister),
                    new Word("kolliti", "younger sister",
                            R.drawable.family_younger_sister, R.raw.family_younger_sister),
                    new Word("ama", "grandmother",
                            R.drawable.family_grandmother, R.raw.family_grandmother),
                    new Word("paapa", "grandfather",
                            R.drawable.family_grandfather, R.raw.family_grandfather)
            ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                audioID = words.get(position).getAudioResorceId();
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, audioID);
                mediaPlayer.start();
            }
        });

    }
}
