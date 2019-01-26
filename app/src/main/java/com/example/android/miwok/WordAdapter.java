package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mListColor;

    public WordAdapter(Context context, ArrayList<Word> words, int ListColor) {

        super(context, 0, words);
        mListColor = ListColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        listItemView.findViewById(R.id.wordContainer)
                .setBackgroundColor(ContextCompat.getColor(getContext(), mListColor));

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = listItemView.findViewById(R.id.miwokWord);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = listItemView.findViewById(R.id.defaultWord);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView wordImage = listItemView.findViewById(R.id.wordImage);

        if (currentWord.hasImage()) {
            wordImage.setImageResource(currentWord.getImageResorceId());
            wordImage.setVisibility(View.VISIBLE);
            wordImage.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.tan_background));

        } else {
            wordImage.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
