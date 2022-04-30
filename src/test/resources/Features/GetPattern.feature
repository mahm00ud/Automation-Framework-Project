Feature: Get Patterns from Colour lover

  Scenario: Number of Views should be greater than 4000 for all patterns.
    Given I send a request to get all Patterns
    Then I should Receive a response body of patterns
    And Number of views Should be greater than 4000

