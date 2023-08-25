package com.demoblaze.challenge.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StringConstants {
    ALPHA_CHARACTER_REGEX("[a-zA-Z]"),
    ASTERISK("*"),
    COLON(":"),
    EMPTY_TEXT_STRING(""),
    LINE_BREAK("\n"),
    MONETARY_SYMBOL("$");

    private final String value;
}
