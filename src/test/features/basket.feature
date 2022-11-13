
  Feature: Verify basket feature

    Background:
      Given I am on home page "https://www.saucedemo.com" with title as "Swag Labs"
      When I enter username "standard_user" and password "secret_sauce"
      And I click login button
      Then I should get re-directed to products page with Heading "PRODUCTS"

    @basket
    Scenario: Verify a product added to the cart

      When I add "Sauce Labs Backpack" to the cart
      And click on basket shopping_cart_link
      Then I should see "Sauce Labs Backpack" in the bag



    Scenario: Verify multiple products added on to the cart

      When I add "Sauce Labs Backpack" to the cart
      And I add "Sauce Labs Bolt T-Shirt" to the cart
      And I add "Sauce Labs Onesie" to the cart
      And click on basket shopping_cart_link
      Then I should see "Sauce Labs Backpack" and "Sauce Labs Bolt T-Shirt" and "Sauce Labs Onesie" in the bag

    @removeItem @basket
    Scenario: Verify remove an item from bag

      When I add "Sauce Labs Backpack" to the cart
      And I click bag icon
      And I click remove button from the bag
      Then I should not see the "Sauce Labs Backpack" in my cart





