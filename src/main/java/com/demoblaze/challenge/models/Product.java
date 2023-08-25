package com.demoblaze.challenge.models;

public class Product {
  private String category;
  private String name;
  private Integer price;
  private String description;

  public Product(String category, String name) {
    this.category = category;
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public String getName() {
    return name;
  }

  public Integer getPrice() {
    return price;
  }

  public String getDescription() {
    return description;
  }
}
