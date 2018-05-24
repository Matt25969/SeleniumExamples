Feature: Testing OMDB API
 
Scenario: test the API
  Given a film exists with the Title IT
  When a user retrieves the film by title
  Then the status code reads 200
  


