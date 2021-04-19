package com.changzakso.changzakso.ui.register.ui.login;

import android.support.annotation.Nullable;

/**
 * Authentication result : success (user details) or error message.
 */
class RegisterResult {
    @Nullable
    private RegisteredInUserView success;
    @Nullable
    private Integer error;

    RegisterResult(@Nullable Integer error) {
        this.error = error;
    }

    RegisterResult(@Nullable RegisteredInUserView success) {
        this.success = success;
    }

    @Nullable
    RegisteredInUserView getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}