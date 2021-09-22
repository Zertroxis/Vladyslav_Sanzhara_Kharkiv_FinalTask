Feature: Smoke
  As a user
  I want to test all main site functional
  So that I can be sure that site works correctly


  Scenario Outline: Check current shop in location

    Given User opens '<homePage>' page
    And User check preferences button visible
    When User click button to chose preferences on home page
    And User check popup is visible and have drop-down list and button to save preferences
    And User click update preferences button to save preferences
    Then User checks '<flag>' on preferences button


    Examples:

      | homePage                  | flag    |
      | https://www.asos.com/men/ | Ukraine |


  Scenario Outline: Check product on page

    Given User opens '<homePage>' page
    And User check search field visible
    When User input '<keyword>' in search field
    And User check search button is active
    And User click on search button
    Then User checks that products on page contains text '<keyText>'


    Examples:

      | homePage                  | keyword  | keyText  |
      | https://www.asos.com/men/ | converse | Converse |


  Scenario Outline: Check filter product and add two cart products

    Given User opens '<homePage>' page
    And User check search field visible
    When User input '<firstKeyword>' in search field
    And User check search button is active
    And User click on search button
    And User open first product on page
    And User chose size European forty
    And User add product to shopping bag
    And User check search field visible
    When User input '<secondKeyword>' in search field
    And User check search button is active
    And User click on search button
    And User filter by man boots
    And User find dr.Martens boots
    And User open dr.Martens boots
    And User chose size United Kingdom ten
    And User add product to shopping bag
    And User click on button on header to shopping bag page
    Then User check '<amountOfProductsInBag>' amount of products in bag


    Examples:
      | homePage                  | firstKeyword | secondKeyword | amountOfProductsInBag |
      | https://www.asos.com/men/ | Converse     | dr.Martens    | 2                     |


  Scenario Outline: Check remove product from shopping bag

    Given User opens '<homePage>' page
    And User check search field visible
    When User input '<keyword>' in search field
    And User check search button is active
    And User click on search button
    And User open first product on page
    And User chose size European forty
    And User add product to shopping bag
    And User click on button on header to shopping bag page
    And User check '<productName>' product on shopping bag page
    Then User remove product from shopping bag
    And User check massage '<emptyBag>' shopping bag have not any product


    Examples:
      | homePage                  | keyword  | productName | emptyBag          |
      | https://www.asos.com/men/ | Converse | Converse    | Your bag is empty |


  Scenario Outline: Check add products to wishlist

    Given User opens '<homePage>' page
    And User click on shoes on header
    And User checks that products on page contains text '<keyText>'
    When User add first product to wishlist
    And User open third product on page
    When User add product to wishlist
    And User click on button header to wishlist page
    Then User check '<amountOfProductsInWishlist>' amount of products in wishlist
    And User check '<productName>' product on wishlist page


    Examples:
      | homePage                  | keyText | amountOfProductsInWishlist | productName |
      | https://www.asos.com/men/ | Vans    | 2                          | Vans        |


  Scenario Outline: Check add product to wishlist and than add to bag

    Given User opens '<homePage>' page
    And User check search field visible
    When User input '<keyword>' in search field
    And User check search button is active
    And User click on search button
    And User open first product on page
    When User add product to wishlist
    And User click on button header to wishlist page
    And User check '<amountOfProductsInWishlist>' amount of products in wishlist
    And User chose size of shoes
    And User check is move to bag button enable
    Then User move product to shopping bag
    And User click view bag on shopping bag popup
    And User check '<amountOfProductsInBag>' amount of products in bag


    Examples:
      | homePage                  | keyword  | amountOfProductsInWishlist | amountOfProductsInBag |
      | https://www.asos.com/men/ | Converse | 1                          | 1                     |


  Scenario Outline: Check internationals deliveries info and changing delivery to country

    Given User opens '<homePage>' page
    When User scroll to header
    And User open help and FAQs
    And User open international deliveries
    Then User check '<whatAreTheBasic>' text
    And User scroll to footer
    And User open delivery and returns
    When User input '<keyword>' in search country field
    Then User change delivery to Great Britain
    And User check is delivery to '<country>' changed


    Examples:
      | homePage                  | whatAreTheBasic                                                                                | keyword | country |
      | https://www.asos.com/men/ | Standard and Express delivery services are available for most of the countries that we ship to | UK      | UK      |


  Scenario Outline: Check remove products from wishlist

    Given User opens '<homePage>' page
    And User check search field visible
    When User input '<keyword>' in search field
    And User check search button is active
    And User click on search button
    When User add first product to wishlist
    And User open third product on page
    When User add product to wishlist
    And User click on button header to wishlist page
    And User check remove all products in wishlist
    Then User check '<emptyProductsInWishlist>' products in wishlist


    Examples:
      | homePage                  | keyword | emptyProductsInWishlist |
      | https://www.asos.com/men/ | adidas  | You have no Saved Items |


