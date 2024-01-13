
@tag
Feature: Purhase from the ecommece application
  I want to use this template for my feature file

   Background:
    Given  I landed on Eommerce page


  @tag2
  Scenario Outline: Purhase product
    Given Login with userName<un> and Password<password>
    When I add product <product> and submit order 
    And CheckOut<product> submit the order 
    Then  "THANKYOU FOR THE ORDER." message is displayed on confirmtion page

    Examples: 
      | un                 | password    |productname    |
      | sampawar@gmail.com |Password@123 |adidas original|
     
