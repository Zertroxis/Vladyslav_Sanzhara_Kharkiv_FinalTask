package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long TIME_TO_WAIT = 20;

    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    HelpAndFAQs helpAndFAQs;
    ShoppingBagPage shoppingBagPage;
    WishlistPage wishlistPage;
    DeliveryAndReturnPage deliveryAndReturnPage;
    ListOfCategoryProductsPage listOfCategoryProductsPage;
    PageFactoryManager pageFactoryManager;
    SingInPage singInPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
    }

    @And("User check preferences button visible")
    public void userCheckIfPreferencesButtonVisible() {
        homePage.isVisiblePreferencesButton();
    }

    @When("User click button to chose preferences on home page")
    public void userClickButtonOnHomePage() {
        homePage.clickOnShopInPreferencesButton();
    }

    @And("User check popup is visible and have drop-down list and button to save preferences")
    public void userCheckIfPopupIsVisibleAndHaveDropDownListAndButtonToSavePreferences() {
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, homePage.loadCountrySelectorFrom());
        homePage.isVisibleCountrySelectorDropdownAndUpdatePreferencesButton();
    }

    @And("User click update preferences button to save preferences")
    public void userClickUpdatePreferencesButtonToSavePreferences() {
        homePage.clickOnUpdatePreferencesButton();
    }

    @Then("User checks {string} on preferences button")
    public void userChecksFlagOnPreferencesButton(final String flagString) {
        Assert.assertTrue(homePage.getTextImgContainsText().contains(flagString));
    }

    @And("User check search field visible")
    public void userCheckSearchFieldVisible() {
        homePage.isVisibleSearchField();
    }

    @When("User input {string} in search field")
    public void userInputKeywordInSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User check search button is active")
    public void userCheckSearchButtonIsActive() {
        homePage.isActiveSearchButton();
    }

    @And("User click on search button")
    public void userClickOnSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("User checks that products on page contains text {string}")
    public void userChecksThatProductsOnPageContainsTextKeyText(final String keyText) {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        listOfCategoryProductsPage = pageFactoryManager.getListOfCategoryProductsPage();
        Assert.assertTrue(listOfCategoryProductsPage.webElementListContainsText().toString().contains(keyText));
    }

    @And("User open first product on page")
    public void userOpenFirstProductOnPage() {
        listOfCategoryProductsPage = pageFactoryManager.getListOfCategoryProductsPage();
        listOfCategoryProductsPage.clickOnFirstProductOnPage();
    }

    @And("User add product to shopping bag")
    public void userAddProductToShoppingBag() {
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        productPage.clickOnAddToBagButton();
    }

    @And("User find dr.Martens boots")
    public void userFindDrMartensBoots() {
        homePage.scrollToElement(listOfCategoryProductsPage.scrollToElementSecondDrMartensBoots());
    }

    @And("User chose size European forty")
    public void userChoseSizeEuropeanForty() {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        productPage = pageFactoryManager.getProductPage();
        productPage.clickOnDropdownListOfProductsSize();
        productPage.clickOnEUSize40();
    }

    @And("User chose size United Kingdom ten")
    public void userChoseSizeUnitedKingdomTen() {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        productPage.clickOnDropdownListOfProductsSize();
        productPage.clickOnUKSize10();
    }

    @And("User filter by man boots")
    public void userFilterByManBoots() {
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, listOfCategoryProductsPage.getWaitToLoadSectionWithMartensBoots());
        listOfCategoryProductsPage.clickOnFilterProductsByGender();
        listOfCategoryProductsPage.clickOnFilterProductsByMan();
        listOfCategoryProductsPage.clickOnFilterProductType();
        listOfCategoryProductsPage.clickOnFilterProductTypeBoots();
        listOfCategoryProductsPage.clickOnFilterProductType();
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, listOfCategoryProductsPage.getWaitToLoadSectionWithMartensBoots());
    }

    @And("User open dr.Martens boots")
    public void userOpenDrMartensBoots() {
        listOfCategoryProductsPage = pageFactoryManager.getListOfCategoryProductsPage();
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToCompletePdp(TIME_TO_WAIT);
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, listOfCategoryProductsPage.scrollToElementSecondDrMartensBoots());
        listOfCategoryProductsPage.clickOnSecondDrMartensBoots();
    }


    @And("User click on button on header to shopping bag page")
    public void userClickOnButtonToShoppingBagPage() {
        homePage.scrollPageHeader();
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, homePage.getWaitToViewBagButton());
        homePage.clickOnPopUpToShoppingBagButton();
    }

    @Then("User check {string} amount of products in bag")
    public void userChecksAmountOfProductsInBagAmountOfProductsInBag(final String expectedResultAmountOfProductsInBag) {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToCompletePdp(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        shoppingBagPage = pageFactoryManager.getShoppingBagPage();
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, shoppingBagPage.getWaitToLoadDescriptionOfProduct());
        Assert.assertEquals(shoppingBagPage.checkCountOfProductsInBag(), expectedResultAmountOfProductsInBag);
    }

    @And("User check {string} product on shopping bag page")
    public void userCheckProductNameProductOnShoppingBagPage(final String productName) {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        shoppingBagPage = pageFactoryManager.getShoppingBagPage();
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, shoppingBagPage.getWaitToLoadDescriptionOfProduct());
        Assert.assertTrue(shoppingBagPage.getTextFromProductDescriptionInBag().toString().contains(productName));
    }

    @Then("User remove product from shopping bag")
    public void userRemoveProductFromShoppingBag() {
        shoppingBagPage.clickOnRemoveFromShoppingBagButton();
    }

    @And("User check massage {string} shopping bag have not any product")
    public void userCheckMassageEmptyBagShoppingBagHaveNotAnyProduct(final String expectMassageResult) {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        shoppingBagPage = pageFactoryManager.getShoppingBagPage();
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, shoppingBagPage.waitToLoadEmptyBagMassage());
        Assert.assertEquals(shoppingBagPage.getMassageThatBagIsEmpty(), expectMassageResult);
    }


    @And("User click on shoes on header")
    public void userClickOnShoesOnHeader() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickOnMensShoesOnHeaderButton();
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, homePage.getWaitToLoadMensShoesVansFromHeaderDropdownListButton());
        homePage.clickOnVansShoesButton();
    }

    @When("User add first product to wishlist")
    public void userAddFirstProductToWishlist() {
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        listOfCategoryProductsPage = pageFactoryManager.getListOfCategoryProductsPage();
        listOfCategoryProductsPage.clickOnFirstProductFromCategoryProductsToWishlist();
    }

    @And("User open third product on page")
    public void userOpenThirdProductOnPage() {
        listOfCategoryProductsPage.clickOnThirdProductToOpenFromCategoryProducts();
    }

    @When("User add product to wishlist")
    public void userAddProductToWishlist() {
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        productPage = pageFactoryManager.getProductPage();
        productPage.clickOnAddToWishlist();
    }

    @And("User click on button header to wishlist page")
    public void userClickOnButtonHeaderToWishlistPage() {
        homePage.scrollPageHeader();
        homePage.clickOnWishListOnHeaderButton();
    }

    @Then("User check {string} amount of products in wishlist")
    public void userCheckAmountOfProductsInWishlistAmountOfProductsInWishlist(final String amountOfProductsInWishlist) {
        wishlistPage = pageFactoryManager.getWishlistPage();
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, wishlistPage.getWaitToLoadContainersWithProducts());
        Assert.assertEquals(wishlistPage.getAmountOfProductsInWishlist(), amountOfProductsInWishlist);
    }

    @And("User check {string} product on wishlist page")
    public void userCheckProductNameProductOnWishlistPage(final String productNameInWishlist) {
        wishlistPage = pageFactoryManager.getWishlistPage();
        Assert.assertTrue(wishlistPage.webElementListContainsText().toString().contains(productNameInWishlist));
    }

    @And("User chose size of shoes")
    public void userChoseSizeOfShoes() {
        wishlistPage = pageFactoryManager.getWishlistPage();
        wishlistPage.clickOnChoseSizeEu40OfShoesForFirstElementInWishListDropdownList();
    }

    @And("User check is move to bag button enable")
    public void userCheckIsMoveToBagButtonEnable() {
        wishlistPage.isActiveMoveToBagFromWishListButton();
    }

    @Then("User move product to shopping bag")
    public void userMoveProductToShoppingBag() {
        wishlistPage = pageFactoryManager.getWishlistPage();
        wishlistPage.clickOnMoveToBagFromWishlistButton();
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, homePage.getWaitToLoadAddToBagProduct());
    }

    @And("User click view bag on shopping bag popup")
    public void userClickViewBagOnShoppingBagPopup() {
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, homePage.getWaitToViewBagButton());
        homePage.clickOnPopUpToShoppingBagButton();
    }

    @When("User scroll to header")
    public void userScrollToHeader() {
        homePage.scrollPageHeader();
    }

    @And("User open help and FAQs")
    public void userOpenHelpAndFAQs() {
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.clickOnOpenHelpAndFAQPageButton();
    }

    @And("User open international deliveries")
    public void userOpenInternationalDeliveries() {
        helpAndFAQs = pageFactoryManager.getHelpAndFAQs();
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        helpAndFAQs.clickOnInternationalDeliveriesPageButton();
    }

    @Then("User check {string} text")
    public void userCheckWhatAreTheBasicText(final String textToCheck) {
        helpAndFAQs = pageFactoryManager.getHelpAndFAQs();
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        Assert.assertTrue(helpAndFAQs.getTextFromInternationalDeliveryContent().toString().contains(textToCheck));
    }

    @And("User scroll to footer")
    public void userScrollToFooter() {
        homePage.scrollPageFooter();
    }

    @And("User open delivery and returns")
    public void userOpenDeliveryAndReturns() {
        helpAndFAQs.clickOnOpenDeliveryAndReturnsPageButton();
    }

    @When("User input {string} in search country field")
    public void userInputKeywordInSearchCountryField(final String inputSearchKeyword) {
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        deliveryAndReturnPage = pageFactoryManager.getDeliveryAndReturnPage();
        deliveryAndReturnPage.isVisibleSearchField();
        deliveryAndReturnPage.clickOnChangeDeliveryToCountryButton();
        deliveryAndReturnPage.enterTextToCountrySearchField(inputSearchKeyword);
        deliveryAndReturnPage.clickOnCountryGreatBritainButton();

    }

    @Then("User change delivery to Great Britain")
    public void userChangeDeliveryToGreatBritain() {
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        deliveryAndReturnPage.clickOnChangeDeliveryToCountryButton();
    }

    @And("User check is delivery to {string} changed")
    public void userCheckIsDeliveryToCountryChanged(final String countyNameCheck) {
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        Assert.assertTrue(deliveryAndReturnPage.checkCountryGreatBritain().contains("UK"));
    }


    @And("User check remove all products in wishlist")
    public void userCheckRemoveAllProductsInWishlist() {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        wishlistPage = pageFactoryManager.getWishlistPage();
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, wishlistPage.getWaitToLoadContainersWithProducts());
        wishlistPage.clickToRemoveAllProductsFromWishlistButton();
    }

    @Then("User check {string} products in wishlist")
    public void userCheckEmptyProductsInWishlistProductsInWishlist(final String checkEmptyBagOutText) {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        wishlistPage = pageFactoryManager.getWishlistPage();
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, wishlistPage.waitToLoadTextThatWishlistIsEmpty());
        Assert.assertEquals(wishlistPage.getTextThatWishlistIsEmpty(), checkEmptyBagOutText);
    }

    @Then("{string} displayed")
    public void searchResultDisplayed(final String displayedResultNotMatch) {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        listOfCategoryProductsPage = pageFactoryManager.getListOfCategoryProductsPage();
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, listOfCategoryProductsPage.waitToLoadNotingMatchesAfterSearch());
        Assert.assertTrue(listOfCategoryProductsPage.getTextFromHeaderTwoNothingMatchesAfterSearch().contains(displayedResultNotMatch));
    }

    @When("User click on account button")
    public void userClickOnAccountButton() {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage = pageFactoryManager.getHomePage();
        homePage.clickOnSingInDropdown();
    }

    @And("User click on sing in")
    public void userClickOnSingIn() {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        homePage = pageFactoryManager.getHomePage();
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, homePage.waitToDisplaySingInButton());
        homePage.clickOnSingIn();
    }

    @And("User check email field and password field are empty")
    public void userCheckEmailFieldAndPasswordFieldAreEmpty() {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        singInPage = pageFactoryManager.getSingInPage();
        Assert.assertTrue(singInPage.getTextFromEmailField().isEmpty());
        Assert.assertTrue(singInPage.getTextFromPasswordField().isEmpty());
    }

    @And("User click on button sing in")
    public void userClickOnButtonSingIn() {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        singInPage = pageFactoryManager.getSingInPage();
        singInPage.clickOnSingInUpButton();
    }

    @Then("User got {string} with information about incorrect data")
    public void userGotErrorPopUpMassageWithInformationAboutIncorrectData(final String checkErrorMassageInEmailField) {
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(TIME_TO_WAIT);
        singInPage = pageFactoryManager.getSingInPage();
        Assert.assertTrue(singInPage.getTextErrorInEmailField().contains(checkErrorMassageInEmailField));
    }


    @After
    public void tearDown() {
        driver.close();
    }


}
