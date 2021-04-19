package com.changzakso.changzakso;

import android.app.Application;

public class CApplication extends Application {

    private static CApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this; //Application 자기 자신 객체
    }

    /* Application 객체 전달 함수 */
    public static CApplication getAppContext() {
        return mContext;
    }
}
