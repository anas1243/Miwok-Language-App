package com.example.android.miwok;

public class Word {
    private String defaultTranslation;
    private String miwokTranslation;

    public Word(String miwokTranslation, String defaultTranslation) {

        this.miwokTranslation = defaultTranslation;
        this.defaultTranslation = miwokTranslation;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }
}
