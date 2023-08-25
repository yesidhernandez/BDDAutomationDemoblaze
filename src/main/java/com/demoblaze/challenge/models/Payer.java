package com.demoblaze.challenge.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Payer {
  private String name;
  private String city;
  private String country;
  private String creditCardNumber;
  private String creditCardExpirationMonth;
  private String creditCardExpirationYear;
}
