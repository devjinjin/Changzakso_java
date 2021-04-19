package com.changzakso.changzakso.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.changzakso.changzakso.CApplication;

public class PropertyManager {
    private static PropertyManager instance;

    public static PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
        }
        return instance;
    }

    private static final String PREF_NAME = "mypref";
    private final SharedPreferences mPrefs;

    private PropertyManager() {
        mPrefs = CApplication.getAppContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }



    private static final String FIELD_USER_LOGIN = "user_login";
    private Boolean mIsLogin;

    public Boolean getUserLogin() {
        if (mIsLogin == null) {
            mIsLogin = mPrefs.getBoolean(FIELD_USER_LOGIN, false);
        }
        return mIsLogin;
    }

    //사용자 이용약관 동의
    public void setUserLogin(Boolean pIsLogin) {
        mIsLogin = pIsLogin;
        SharedPreferences.Editor mEditor = mPrefs.edit();
        mEditor.putBoolean(FIELD_USER_LOGIN, mIsLogin);
        mEditor.apply();
    }
}
