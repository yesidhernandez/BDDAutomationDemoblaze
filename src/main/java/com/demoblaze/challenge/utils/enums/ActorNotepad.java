package com.demoblaze.challenge.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ActorNotepad {
    FULL_PURCHASE_PRICE("Full purchase price"),
    PRODUCT_PRICE("Product price");

    private final String value;
}
