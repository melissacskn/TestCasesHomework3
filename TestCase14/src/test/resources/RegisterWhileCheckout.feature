Feature: Registering while checkout
  Scenario: User registers while doing checking out
    Given launch browser
    When user navigates to home page
    Then verify that home page is visible

    Given add products to cart
    When user clicks on X button
    Then verify that cart page is visible

    Given click to proceed to checkout
    And click on register/login button
    When  fill all the details in signup and create account
    Then verify Account Created
    And click continue button
    Then Verify Logged in as username at top

    Given Click Cart button
    When Click Proceed To Checkout button
    Then verify Address Details and Review Your Order

    Given Enter description in comment text area and click Place Order
    And Enter payment details: Name on Card, Card Number, CVC, Expiration date
    When Click Pay and Confirm Order button
    Then Verify success message Your order has been placed successfully!



