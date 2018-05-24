Feature: Working with a Stack
  As a person
  I want to store things in a stack
  So that I can demonstrate it works

  Scenario: Push an item into a stack
    Given an empty stack
    When I push an item into the stack
    Then the stack contains one item

  Scenario: Push two items into a stack
    Given an empty stack
    When I push an item into the stack
    And I push another item into the stack
    Then the stack contains two items

  Scenario: Pop a given item from the stack
    Given an empty stack
    When I push an item into the stack
    And I pop from the stack
    Then I get the same item back
    
      Scenario: Pop a given item from the stack
    Given a full stack
    When I push an item into the stack
    And I pop from the stack
    Then I get the same item back
