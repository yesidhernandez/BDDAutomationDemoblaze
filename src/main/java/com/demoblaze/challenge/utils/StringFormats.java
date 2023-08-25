package com.demoblaze.challenge.utils;

import static com.demoblaze.challenge.utils.enums.StringConstants.*;

public class StringFormats {
    public static String removeLettersAndSpecialCharacters(String value) {
        return value
                .replaceAll(ALPHA_CHARACTER_REGEX.getValue(), EMPTY_TEXT_STRING.getValue())
                .replace(ASTERISK.getValue(), EMPTY_TEXT_STRING.getValue())
                .replace(MONETARY_SYMBOL.getValue(), EMPTY_TEXT_STRING.getValue())
                .trim();
    }
}
