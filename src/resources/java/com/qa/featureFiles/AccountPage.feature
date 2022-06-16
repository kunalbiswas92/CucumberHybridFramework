Feature: Account page functionality

  Background: 
    Given user lanches the application URL
    And lands on home page with title "My Store"
    When user clicks on sign in button on home page
    And is directed to the login page with title "Login - My Store"
    Then user enters the correct username "jsmith.u1@gmail.com" and password "Kunalb@123"
    And logs into the account with page title "My account - My Store"

  Scenario: Verify user is able to see all five personal details and orders section
    Then user should get the personal information section with below links
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
