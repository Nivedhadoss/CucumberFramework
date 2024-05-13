@Complete
Feature: Amazon Search Validation

  Background: Pre-Condition for Amazon
    #Given User should launch the edge browser for Amazon
    Given User should navigate to Amazon

  @Smoke 
  Scenario: Search product using data table from feature file data for Amazon
    When User search with multiple products in Amazon called
      | ProdName | ProdCat     |
      | Nokia    | Electronics |
      | Selenium | Books       |
    Then Validate the Amazon search result
