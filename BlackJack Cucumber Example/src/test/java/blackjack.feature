Feature: Playing the game of BlackJack
  As a player
  I want to play a game of BlackJack
  So that I can beat the computer

  Scenario: Drawing lower than computer whilst they draw under Twenty-One
    Given an integer a and an integer b
    When a is less than b and b is less than Twenty-One
    Then b is returned

  Scenario: Drawing under Twenty-One whilst they draw above Twenty-One
    Given an integer a and an integer b which is above Twenty-One
    When an integer a and b is above Twenty-One
    Then a is returned

  Scenario: Drawing higher than computer and lower than Twenty-One
    Given an integer a and an integer b
    When a is greater than b and a is less than Twenty-One
    Then a is returned

  Scenario: Drawing higher than computer and under Twenty-One whilst they draw above Twenty-One
    Given an integer a and an integer b which is above Twenty-One
    When a is higher than b and less than Twenty-One and b is above Twenty-One
    Then a is returned

  Scenario: Drawing the same as the computer and both under Twenty-One
    Given an integer a and an integer b which are both under Twenty-One
    When an integer a and b both under Twenty-One
    Then the identical value of a and b is returned

  Scenario: Drawing the same as the computer and both over Twenty-One
    Given an integer a and an integer b which are both over Twenty-One
    When an integer a and b both over Twenty-One
    Then then Zero is returned
