Feature: Verify the checkout feature

  Scenario: Verify the checkout process
    Given I am on home page "https://www.saucedemo.com" with title as "Swag Labs"
    When I enter username "standard_user" and password "secret_sauce"
    And I click login button
    Then I should get re-directed to products page with Heading "PRODUCTS"
    When I add "Sauce Labs Backpack" to the cart
    And click on basket shopping_cart_link
    Then I should see "Sauce Labs Backpack" in the bag
    When I click on "checkout" with heading "CHECKOUT: YOUR INFORMATION"
    And Enter First Name "George" and  Last Name "Jonny" and Postal Code "cw9 2lg"
    And I click continue button
    And I should have "1" in quantity and "CHECKOUT: OVERVIEW"
    Then I see the thank you message is displayed with the page heading "CHECKOUT: COMPLETE!"

