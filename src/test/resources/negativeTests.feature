Feature: NegativeTests
  As a user
  I want to test site functional
  So that I can be sure that site works correctly with incorrect parameters


  Scenario Outline: Check incorrect data to search

    Given User opens '<homePage>' page
    And User check search field visible
    When User input '<keyword>' in search field
    And User check search button is active
    And User click on search button
    Then '<searchResult>' displayed


    Examples:
      | homePage                  | keyword        | searchResult                |
      | https://www.asos.com/men/ | ывфаффаацуцычс | NOTHING MATCHES YOUR SEARCH |

  Scenario Outline: Check incorrect data to email field

    Given User opens '<homePage>' page
    When User click on account button
    And User click on sing in
    And User check email field and password field are empty
    And User click on button sing in
    Then User got '<errorPopUpMassage>' with information about incorrect data


    Examples:
      | homePage                  | errorPopUpMassage                      |
      | https://www.asos.com/men/ | Oops! You need to type your email here |