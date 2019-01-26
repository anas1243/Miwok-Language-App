package com.example.android.miwok;

public class Word {

    private String miwokTranslation;
    private String defaultTranslation;
    private int imageResorceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;


    public Word(String miwokTranslation, String defaultTranslation, int imageResorceId) {

        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.imageResorceId = imageResorceId;
    }

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

    public int getImageResorceId() {
        return imageResorceId;
    }

    public boolean hasImage() {
        return this.imageResorceId != NO_IMAGE_PROVIDED;
    }
}
