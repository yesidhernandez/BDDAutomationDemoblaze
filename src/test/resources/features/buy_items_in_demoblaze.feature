Feature: Make purchase on demoblaze.
  Me as a quality analyst
  I want to make purchase on demoblaze
  To ensure that demoblaze page works correctly

  Scenario: Make purchase on demoblaze.
    Given that Yesid opens the demoblaze page in the browser
    And he accesses the demoblaze page using user defined credentials
    When he selects the following products for purchase
      | category | name             |
      | Phones   | Sony xperia z5   |
      | Laptops  | ASUS Full HD     |
      | Monitors | Apple monitor 24 |
      | Laptops  | MacBook air      |
    And he places the order
    Then he should see that the payment made corresponds to the value of the selected items
