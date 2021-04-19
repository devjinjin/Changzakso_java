package com.changzakso.changzakso.ui.register.ui.login;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Patterns;

import com.changzakso.changzakso.R;
import com.changzakso.changzakso.ui.register.data.RegisterRepository;
import com.changzakso.changzakso.ui.register.data.RegisterResult;
import com.changzakso.changzakso.ui.register.data.model.RegisteredInUser;

public class RegisterViewModel extends ViewModel {

    private MutableLiveData<RegisterFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<com.changzakso.changzakso.ui.register.ui.login.RegisterResult> loginResult = new MutableLiveData<>();
    private RegisterRepository loginRepository;

    RegisterViewModel(RegisterRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<RegisterFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<com.changzakso.changzakso.ui.register.ui.login.RegisterResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        // can be launched in a separate asynchronous job
        RegisterResult<RegisteredInUser> result = loginRepository.login(username, password);

        if (result instanceof RegisterResult.Success) {
            RegisteredInUser data = ((RegisterResult.Success<RegisteredInUser>) result).getData();
            loginResult.setValue(new com.changzakso.changzakso.ui.register.ui.login.RegisterResult(new RegisteredInUserView(data.getDisplayName())));
        } else {
            loginResult.setValue(new com.changzakso.changzakso.ui.register.ui.login.RegisterResult(R.string.login_failed));
        }
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new RegisterFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new RegisterFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new RegisterFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}