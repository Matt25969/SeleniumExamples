
Feature: Searching for terms
As a User
I want to search for a particular term
So that I can see information about it

   Scenario Outline: Search bing for google
   Given I go to "<website>" website
   When I search for "<searchTerm>"
   Then I am taken to a list of data for that search
   
Examples:
    | website   | searchTerm |
    | https://www.bing.com | QAConsulting |
    | https://www.bing.com | Guru99 |
    | https://www.bing.com | BlazeDemo |
    | https://www.bing.com | Automated Testing |