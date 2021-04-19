package com.changzakso.changzakso.ui.base;

import android.support.v4.app.Fragment;

public class BaseIntroFragment extends Fragment {

    //Splash , Download 를 위한 리스너 객체
    protected OnFragmentIntroListener mIntroListener;

    public interface OnFragmentIntroListener {
        //이용약관
        void onRequestAgreementPage();

        //이용약관 확인을 했을시
        void onAgreeDone();

        void onRequestRegisterPage();

        //오류로 인해 재실행 요청
        void onRequestRestart();

        void onResisterDone();

        void onLoginDone();
    }
}
