package com.demoblaze.challenge.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MainMenu {
    ABOUT_US("About us"),
    CART("Cart"),
    CONTACT("Contact"),
    HOME("Home "),
    LOG_IN("Log in"),
    LOG_OUT("Log out"),
    SIGN_UP("Sign up");

    private final String value;
}
