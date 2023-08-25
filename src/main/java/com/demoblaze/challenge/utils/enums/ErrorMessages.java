package com.demoblaze.challenge.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessages {
  WRONG_PRICE_ERROR("El valor total pagado por los articulos adquiridos es incorrecto. \n");

  private final String Message;
}
