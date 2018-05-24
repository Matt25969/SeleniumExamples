Feature: Shopping on a website
  As a person
  I want to browse items on a website
  So that I can purhcase the items I want

Scenario: Browse the items available on the website
  Given the correct web address
  When I navigate to the 'Menu' page
  Then I can browse a list of the available products.

Scenario: Add an item to the checkout
  Given the correct web address
  When I click the checkout button
  Then I am taken to the checkout page

