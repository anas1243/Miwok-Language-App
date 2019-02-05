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
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

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
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

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
                releaseMediaPlayer();
                audioID = words.get(position).getAudioResorceId();
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, audioID);
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });

    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
