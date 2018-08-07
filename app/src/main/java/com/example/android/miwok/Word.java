package com.example.android.miwok;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
    //Constructor
    public Word(String defaultWord, String miwokWord){
        mDefaultTranslation = defaultWord;
        mMiwokTranslation = miwokWord;
    }
}
