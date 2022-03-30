Feature: Test a successful login on Mercury Tours

  Scenario: Successful login with valid credentials
    Given that I am on the Mercury Tours login page
    When I logon with my credentials
    Then I navigate to home page
