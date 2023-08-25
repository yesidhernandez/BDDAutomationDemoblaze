package com.demoblaze.challenge.exceptions;

public class UnexpectedValueError extends AssertionError {
  public UnexpectedValueError(String message, Throwable cause) {
    super(message, cause);
  }
}
