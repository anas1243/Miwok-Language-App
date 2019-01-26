package com.example.android.miwok;

public class Word {

    private String miwokTranslation;
    private String defaultTranslation;
    private int imageResorceId;


    public Word(String miwokTranslation, String defaultTranslation, int imageResorceId) {

        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.imageResorceId = imageResorceId;
    }

    public Word(String miwokTranslation, String defaultTranslation) {

        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.imageResorceId=0;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public int getImageResorceId() {
        return imageResorceId;
    }
}
