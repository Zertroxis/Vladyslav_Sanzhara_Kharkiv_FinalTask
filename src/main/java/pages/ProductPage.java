package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//select[@data-id = 'sizeSelect']")
    private WebElement dropdownListOfProductSize;

    @FindBy(xpath = "//select[@data-id = 'sizeSelect']/option[contains(text(),'EU 40')]")
    private WebElement euSize40;

    @FindBy(xpath = "//select[@data-id = 'sizeSelect']/option[contains(text(),'UK 10')]")
    private WebElement ukSize10;

    @FindBy(xpath = "//span[@data-bind = 'text: buttonText'] ")
    private WebElement addToBagButton;

    @FindBy(xpath = "//button[@class = 'save-button']")
    private WebElement addToWishlist;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDropdownListOfProductsSize() {
        dropdownListOfProductSize.click();
    }

    public void clickOnEUSize40() {
        euSize40.click();
    }

    public void clickOnUKSize10() {
        ukSize10.click();
    }

    public void clickOnAddToBagButton() {
        addToBagButton.click();
    }

    public void clickOnAddToWishlist() {
        addToWishlist.click();
    }
}
