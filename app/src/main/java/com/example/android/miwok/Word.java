package com.example.android.miwok;

public class Word {

    private String miwokTranslation;
    private String defaultTranslation;


    public Word(String miwokTranslation, String defaultTranslation) {

        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }
}
