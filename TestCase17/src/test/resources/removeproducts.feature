Feature: Remove Products From Cart
  Scenario: User Should verify home page is visible
    Given Launch browser
    When Navigate to the home page
    Then Verify that home page is visible successfully

      Given User adds products to cart
      When User click's to the Cart button
      Then User is verified that cart page is displayed

        Given On Carts page
        When User clicks to X button
        Then Verified that product is removed from cart