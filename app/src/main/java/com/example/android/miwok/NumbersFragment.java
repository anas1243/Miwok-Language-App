package com.example.android.miwok;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    private int audioID;
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };



    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<>(
                Arrays.asList(new Word("lutti", "one"
                                , R.drawable.number_one, R.raw.number_one),
                        new Word("otiiko", "two",
                                R.drawable.number_two, R.raw.number_two),
                        new Word("tolookosu", "three",
                                R.drawable.number_three, R.raw.number_three),
                        new Word("oyyisa", "four",
                                R.drawable.number_four, R.raw.number_four),
                        new Word("massokka", "five",
                                R.drawable.number_five, R.raw.number_five),
                        new Word("temmokka", "six",
                                R.drawable.number_six, R.raw.number_six),
                        new Word("kenekaku", "seven",
                                R.drawable.number_seven, R.raw.number_seven),
                        new Word("kawinta", "eight",
                                R.drawable.number_eight, R.raw.number_eight),
                        new Word("wo’e", "nine",
                                R.drawable.number_nine, R.raw.number_nine),
                        new Word("na’aacha", "ten",
                                R.drawable.number_ten, R.raw.number_ten)
                ));

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_numbers);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                audioID = words.get(position).getAudioResorceId();
                mMediaPlayer = MediaPlayer.create(getActivity(), audioID);
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });
        return rootView;
    }

}
