package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WishlistPage extends BasePage {

    @FindBy(xpath = "//li/div/div/div/a[@aria-label]")
    private List<WebElement> amountOfProductsInWishlist;

    @FindBy(xpath = "//div[@id='saved-lists-app']")
    private WebElement waitToLoadWishlist;

    @FindBy(xpath = "//li[1]/..//select[@aria-label='Size']/option[text()='EU 40']")
    private WebElement choseSizeEU40OfShoesForFirstElementInWishListDropdownList;

    @FindBy(xpath = "//li[1]/..//button[text()='Move to bag']")
    private WebElement moveToBagFromWishListButton;

    @FindBy(xpath = "//button[@aria-label='Delete']")
    private List<WebElement> deleteProductFromWishlistButton;

    @FindBy(xpath = "//div[@id='saved-lists-app']/..//h2")
    private WebElement headerTextAboutEmptyWishlist;

    @FindBy(xpath = "//div[@aria-hidden='false']")
    private WebElement waitToLoadContainersWithProducts;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public String getAmountOfProductsInWishlist() {
        return String.valueOf(amountOfProductsInWishlist.size());
    }

    public List<String> webElementListContainsText() {
        List<String> listOfProductsText = new ArrayList<>();
        for (WebElement webElement : amountOfProductsInWishlist
        ) {
            listOfProductsText.add(webElement.getAttribute("aria-label"));
        }
        return listOfProductsText;
    }

    public void clickOnChoseSizeEu40OfShoesForFirstElementInWishListDropdownList() {
        choseSizeEU40OfShoesForFirstElementInWishListDropdownList.click();
    }

    public void isActiveMoveToBagFromWishListButton() {
        moveToBagFromWishListButton.isEnabled();
    }

    public void clickOnMoveToBagFromWishlistButton() {
        if (moveToBagFromWishListButton.getAttribute("disabled") == null) {
            moveToBagFromWishListButton.click();
        }
    }

    public void clickToRemoveAllProductsFromWishlistButton() {
        for (WebElement elementProductsToRemove : deleteProductFromWishlistButton
        ) {
            elementProductsToRemove.click();
        }
    }

    public WebElement waitToLoadTextThatWishlistIsEmpty() {
        return headerTextAboutEmptyWishlist;
    }

    public String getTextThatWishlistIsEmpty() {
        return headerTextAboutEmptyWishlist.getText();
    }

    public WebElement getWaitToLoadContainersWithProducts() {
        return waitToLoadContainersWithProducts;
    }

}
