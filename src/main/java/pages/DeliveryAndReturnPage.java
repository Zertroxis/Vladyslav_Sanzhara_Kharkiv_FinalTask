package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryAndReturnPage extends BasePage {

    @FindBy(xpath = "//button[@class='dr-country-selector_button js-open-modal'][text()='Change']")
    private WebElement changeDeliveryToCountryButton;

    @FindBy(xpath = "//input[@class='dr-country-picker_input icon-search']")
    private WebElement inputSearchFieldForCountries;

    @FindBy(xpath = "//li/a[@data-country='gb']")
    private WebElement clickOnGreatBritainCountry;

    @FindBy(xpath = "//div[@class='dr-country-selector']/span[contains(text(),'UK')]")
    private WebElement checkCountryGreatBritain;

    public DeliveryAndReturnPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnChangeDeliveryToCountryButton(){
        changeDeliveryToCountryButton.click();
    }

    public void enterTextToCountrySearchField(final String searchText) {
        inputSearchFieldForCountries.sendKeys(searchText);
    }

    public void isVisibleSearchField() {
        inputSearchFieldForCountries.isDisplayed();
    }

    public void clickOnCountryGreatBritainButton(){
        clickOnGreatBritainCountry.click();
    }

    public String checkCountryGreatBritain() {

        return checkCountryGreatBritain.getText();
    }
}
