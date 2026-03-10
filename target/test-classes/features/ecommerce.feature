
Feature: Ecommerce purchase flow

Scenario: User buys a product successfully

Given user launches the application
And user logs in with valid credentials
When user selects a product
And user adds product to cart
And user proceeds to checkout
And user enters checkout details
Then user completes the purchase
