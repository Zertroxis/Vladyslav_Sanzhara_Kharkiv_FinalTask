package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    @FindBy(tagName = "header")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = "//div[@data-testid='topbar']//div[@data-testid = 'country-selector']/button")
    private WebElement preferencesButton;

    @FindBy(xpath = "//div[@data-testid='topbar']//div[@data-testid = 'country-selector']/button/img[@alt]")
    private WebElement imgShopInFlagUkraine;

    @FindBy(xpath = "//select[@id = 'country']")
    private WebElement countrySelectorDropdowmList;

    @FindBy(xpath = "//button[@data-testid = 'save-country-button']")
    private WebElement updatePreferencesButton;

    @FindBy(xpath = "//section[@data-testid = 'country-selector-form']")
    private WebElement countrySelectorPopUpForm;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement inputSearchField;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchInputButton;

    @FindBy(xpath = "//a[@data-testid ='miniBagIcon']")
    private WebElement openBagOnHeader;

    @FindBy(xpath = "//div/div[2]/nav//div/div/button[@data-testid = 'primarynav-button']/span/span[text()='Shoes']")
    private WebElement openMensShoesHeaderDropdownListButton;

    @FindBy(xpath = "//ul[@class='_1oG3guj'][@aria-labelledby='shop-by-brand-a11']/li/a/span[@class='_3lfjYlZ _2nyXJLR _2trK-uN _1oL3gfq'][text()='Vans']")
    private WebElement openMensShoesVansFromHeaderDropdownListButton;

    @FindBy(xpath = "//a[@href='https://www.asos.com/men/a-to-z-of-brands/vans/cat/?cid=2465&refine=attribute_1047:8609,8606&nlid=mw|shoes|shop+by+brand|vans']")
    private WebElement waitToLoadMensShoesVansFromHeaderDropdownListButton;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement openWishlistPageOnHeaderButton;

    @FindBy(xpath = "//span[@type='bagFilled']")
    private WebElement waitToLoadAddToBagProduct;

    @FindBy(xpath = "//a[@data-test-id='bag-link']")
    private WebElement openShoppingBagLinkButton;

    @FindBy(xpath = "//a[@data-testid='help']")
    private WebElement openHelpAndFAQsPageButton;

    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement openDropdownAccountList;

    @FindBy(xpath = "//a[@data-testid = 'signin-link'][text()='Sign In']")
    private WebElement clickOnSingInButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickOnShopInPreferencesButton() {
        preferencesButton.click();
    }

    public void isVisiblePreferencesButton() {
        preferencesButton.isDisplayed();
    }

    public void isVisibleCountrySelectorDropdownAndUpdatePreferencesButton() {
        countrySelectorDropdowmList.isDisplayed();
        updatePreferencesButton.isDisplayed();
    }

    public void clickOnUpdatePreferencesButton() {
        updatePreferencesButton.click();
    }

    public WebElement loadCountrySelectorFrom() {
        return countrySelectorPopUpForm;
    }

    public String getTextImgContainsText() {
        return imgShopInFlagUkraine.getAttribute("alt");
    }

    public void enterTextToSearchField(final String searchText) {
        inputSearchField.clear();
        inputSearchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchInputButton.click();
    }

    public void isVisibleSearchField() {
        inputSearchField.isDisplayed();
    }

    public void isActiveSearchButton() {
        searchInputButton.isEnabled();
    }

    public void scrollPageHeader() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", header);
    }

    public void scrollPageFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", footer);
    }

    public void clickOnMensShoesOnHeaderButton() {
        openMensShoesHeaderDropdownListButton.click();
    }

    public void clickOnVansShoesButton() {
        openMensShoesVansFromHeaderDropdownListButton.click();
    }

    public WebElement getWaitToLoadMensShoesVansFromHeaderDropdownListButton() {
        return waitToLoadMensShoesVansFromHeaderDropdownListButton;
    }

    public void clickOnWishListOnHeaderButton() {
        openWishlistPageOnHeaderButton.click();
    }

    public WebElement getWaitToLoadAddToBagProduct() {
        return waitToLoadAddToBagProduct;
    }

    public WebElement getWaitToViewBagButton() {
        return openShoppingBagLinkButton;
    }

    public void clickOnPopUpToShoppingBagButton() {
        openShoppingBagLinkButton.click();
    }

    public void clickOnOpenHelpAndFAQPageButton() {
        openHelpAndFAQsPageButton.click();
    }

    public void clickOnSingIn() {
        clickOnSingInButton.click();
    }

    public void clickOnSingInDropdown() {
        openDropdownAccountList.click();
    }

    public WebElement waitToDisplaySingInButton() {
        return clickOnSingInButton;
    }

}
