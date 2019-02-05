package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PhrasesActivity extends AppCompatActivity {

    private int audioID;
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    ArrayList<Word> words = new ArrayList<>(
            Arrays.asList(new Word("minto wuksus", "Where are you going?", R.raw.phrase_where_are_you_going),
                    new Word("tinnә oyaase'nә", "What is your name?", R.raw.phrase_what_is_your_name),
                    new Word("oyaaset...", "My name is...", R.raw.phrase_my_name_is),
                    new Word("michәksәs?", "How are you feeling?", R.raw.phrase_how_are_you_feeling),
                    new Word("kuchi achit", "I’m feeling good.", R.raw.phrase_im_feeling_good),
                    new Word("әәnәs'aa?", "Are you coming?", R.raw.phrase_are_you_coming),
                    new Word("hәә’ әәnәm", "Yes, I’m coming.", R.raw.phrase_yes_im_coming),
                    new Word("әәnәm", "I’m coming.", R.raw.phrase_im_coming),
                    new Word("yoowutis", "Let’s go.", R.raw.phrase_lets_go),
                    new Word("әnni'nem", "Come here.", R.raw.phrase_come_here)
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

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                audioID = words.get(position).getAudioResorceId();
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, audioID);
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
