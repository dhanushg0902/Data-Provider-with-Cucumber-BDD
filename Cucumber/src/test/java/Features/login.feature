Feature: Login functionality on SauceDemo website

  Scenario Outline: User logs in with valid credentials
    Given User is on the SauceDemo login page
    When User logs in with ID "<id>"
    Then User should be logged in successfully

  Examples:
    | id |
    | 1  |
    | 2  |
    | 3  |
    | 4  |
    | 5  |
    | 6  |