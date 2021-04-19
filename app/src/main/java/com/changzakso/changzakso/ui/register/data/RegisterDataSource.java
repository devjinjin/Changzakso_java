package com.changzakso.changzakso.ui.register.data;

import com.changzakso.changzakso.ui.register.data.model.RegisteredInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class RegisterDataSource {

    public RegisterResult<RegisteredInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            RegisteredInUser fakeUser =
                    new RegisteredInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new RegisterResult.Success<>(fakeUser);
        } catch (Exception e) {
            return new RegisterResult.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}