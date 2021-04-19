package com.changzakso.changzakso.ui.register.data;

import com.changzakso.changzakso.ui.register.data.model.RegisteredInUser;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class RegisterRepository {

    private static volatile RegisterRepository instance;

    private RegisterDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private RegisteredInUser user = null;

    // private constructor : singleton access
    private RegisterRepository(RegisterDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static RegisterRepository getInstance(RegisterDataSource dataSource) {
        if (instance == null) {
            instance = new RegisterRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        dataSource.logout();
    }

    private void setLoggedInUser(RegisteredInUser user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public RegisterResult<RegisteredInUser> login(String username, String password) {
        // handle login
        RegisterResult<RegisteredInUser> result = dataSource.login(username, password);
        if (result instanceof RegisterResult.Success) {
            setLoggedInUser(((RegisterResult.Success<RegisteredInUser>) result).getData());
        }
        return result;
    }
}