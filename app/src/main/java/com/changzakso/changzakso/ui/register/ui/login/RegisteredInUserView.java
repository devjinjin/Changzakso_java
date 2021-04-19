package com.changzakso.changzakso.ui.register.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class RegisteredInUserView {
    private String displayName;
    //... other data fields that may be accessible to the UI

    RegisteredInUserView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }
}