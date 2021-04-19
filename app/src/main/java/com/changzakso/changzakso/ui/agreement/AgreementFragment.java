package com.changzakso.changzakso.ui.agreement;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.changzakso.changzakso.R;
import com.changzakso.changzakso.ui.base.BaseIntroFragment;


public class AgreementFragment extends BaseIntroFragment {


    public static AgreementFragment newInstance() {
        return new AgreementFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_agreement, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseIntroFragment.OnFragmentIntroListener) {
            mIntroListener = (BaseIntroFragment.OnFragmentIntroListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentIntroListener");
        }
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof BaseIntroFragment.OnFragmentIntroListener) {
            mIntroListener = (BaseIntroFragment.OnFragmentIntroListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentIntroListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mIntroListener = null;
    }
}