package com.changzakso.changzakso;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.changzakso.changzakso.ui.agreement.AgreementFragment;
import com.changzakso.changzakso.ui.base.BaseIntroFragment;
import com.changzakso.changzakso.ui.login.ui.login.LoginFragment;
import com.changzakso.changzakso.ui.register.ui.login.RegisterFragment;
import com.changzakso.changzakso.ui.splash.SplashFragment;
import com.changzakso.changzakso.utils.PropertyManager;

public class IntroActivity extends AppCompatActivity implements BaseIntroFragment.OnFragmentIntroListener{
    //Splash delay handler
    private final Handler mWaitHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SplashFragment.newInstance())
                    .commitNow();
        }

        mWaitHandler.postDelayed(initWaitRunnable, 1000);

    }

    //최초 진입시 Runnable
    private final Runnable initWaitRunnable = new Runnable() {
        @Override
        public void run() {
            mWaitHandler.removeCallbacks(initWaitRunnable);

            if (PropertyManager.getInstance().getUserLogin()) {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
            } else {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, LoginFragment.newInstance())
                        .commitNow();
            }
        }
    };

    @Override
    public void onRequestAgreementPage() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, AgreementFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onAgreeDone() {

    }

    @Override
    public void onRequestRegisterPage() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, RegisterFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void onRequestRestart() {

    }

    @Override
    public void onResisterDone() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow();
    }

    @Override
    public void onLoginDone() {
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(intent);
    }
}