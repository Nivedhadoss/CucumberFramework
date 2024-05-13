@Complete
Feature: Ebay Product Search validation

  Background: Invoke Browser and Navigate to URL
    And I should navigate to Ebay URL

  @Smoke
  Scenario: Ebay search by hardcoding the values from Step definition.
    When I will type the product and select the product catagory
    And I will click on search button
    Then I should see the search product result
    #And Close the browser

 @Regression
  Scenario: Ebay search by hardcoding the values from feature file using step parameter using data table as Map.
    When I will type the product name from the below data table as a map
      | ProductName | ProductCatagory               |
      | iPhone      | Cell Phones & Accessories     |
      | T-Shirt     | Clothing, Shoes & Accessories |
    And I will click on search button
    Then I should see the search product result
    And Close the browser


  @Sanity
  Scenario Outline: Ebay search by hardcoding multiple values from feature file.
    When I will type the multiple product name as <ProductName> and select the multiple product catagory as <ProductCatagory>
    And I will click on search button
    Then I should see the search product result


    @Accessories
    Examples: 
      | ProductName | ProductCatagory               |
      | iPhone      | Cell Phones & Accessories     |
      | T-Shirt     | Clothing, Shoes & Accessories |

    @Books
    Examples: 
      | ProductName | ProductCatagory |
      | Java        | Books           |
      | Selenium    | Books           |
