package com.demoblaze.challenge.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnvironmentVariables {
  DEMOBLAZE_USERNAME("demoblaze.username"),
  DEMOBLAZE_PASSWORD("demoblaze.password");

  private final String environmentVariable;
}
