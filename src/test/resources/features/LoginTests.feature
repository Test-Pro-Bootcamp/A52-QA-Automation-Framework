Feature: Login Tests

  Scenario: Login Success
    Given I open login page
    When I enter email "azat@testpro.io"
    And I enter password "Qwerty123!"
    And I submit
    Then I am logged in