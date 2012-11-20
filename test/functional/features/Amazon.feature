Feature: Browsing Amazon Products
    In order to buy products
    As an Amazon customer
    I want to be able to browse products

Scenario: Search For Products By Topic
    Given I am on the Amazon homepage
    When I search for "clean code"
    Then I should see results with the name "clean code"

Scenario: Browse What Other Users Are Looking At
    Given I am on the Amazon homepage
    Then I should see products other users are looking at