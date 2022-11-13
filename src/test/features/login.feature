Feature: Verify login feature

  @login @smoke
  Scenario: Verify login with valid username and password

    Given I am on home page "https://www.saucedemo.com" with title as "Swag Labs"
    When I enter username "standard_user" and password "secret_sauce"
    And I click login button
    Then I should get re-directed to products page with Heading "PRODUCTS"

  @login
  Scenario: Verify login with invalid username and password

    Given I am on home page "https://www.saucedemo.com" with title as "Swag Labs"
    When I enter username "standard_user_inv" and password "secret_sauce_inv"
    And I click login button
    Then I should not be allowed to login instead "Epic sadface: Username and password do not match any user in this service"

  @login
  Scenario: Verify login with no username and password

    Given I am on home page "https://www.saucedemo.com" with title as "Swag Labs"
    And I click login button
    Then I should not be allowed to login instead "Epic sadface: Username is required"