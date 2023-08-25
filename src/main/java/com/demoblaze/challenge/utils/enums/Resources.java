package com.demoblaze.challenge.utils.enums;

public enum Resources {
  DEMOBLAZE_URL("https://www.demoblaze.com"),
  HEXACTA_URL("https://www.hexacta.com");

  private final String value;

  Resources(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
