Feature: Placing order on sportsstore
  Scenario: User places an order
    Given User is on sportsstore homepage
    When  User clicks on Chess category
    And User adds Think cap to the cart
    And User proceeds to checkout
    And User fills order information
    Then User should see order confirmation message
    Then Return To Store