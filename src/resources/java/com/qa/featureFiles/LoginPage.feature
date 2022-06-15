Feature: Login functionality


  Background: 
    Given user lanches the application URL
    And lands on home page with title "My Store"

  Scenario: Verify user is able to see the sign in button on home page
    Then user should be able to see the sign in button on home page

  Scenario: Verify user can succesfully login to application using correct username and password
    When user clicks on sign in button on home page
    And is directed to the login page with title "Login - My Store"
    Then user enters the correct username "jsmith.u1@gmail.com" and password "Kunalb@123"
    And logs into the account with page title "My account - My Store"
