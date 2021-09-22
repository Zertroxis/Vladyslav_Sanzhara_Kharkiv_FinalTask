package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class ShoppingBagPage extends BasePage {

    @FindBy(xpath = "//div[@class='bag-item-descriptions']")
    private List<WebElement> listOfProductsInShoppingCart;

    @FindBy(xpath = "//body[@class= 'bagpage-fixed-header']")
    private WebElement waitToLoadPageElementInBag;

    @FindBy(xpath = "//button[@class = 'bag-item-remove']")
    private List<WebElement> removeFromShoppingBagButton;

    @FindBy(xpath = "//h2[@class='empty-bag-title']")
    private WebElement massageHeaderEmptyBag;

    @FindBy(xpath = "//a[@data-bind ='attr: { href: getLink() }, text: item.name ']")
    private List<WebElement> getTextFromProductDescriptionInBag;

    @FindBy(xpath = "//div[@class='bag-item-descriptions']")
    private WebElement waitToLoadDescriptionOfProduct;

    public ShoppingBagPage(WebDriver driver) {
        super(driver);
    }

    public String checkCountOfProductsInBag() {
        return String.valueOf(listOfProductsInShoppingCart.size());
    }

    public WebElement waitToLoadEmptyBagMassage() {
        return massageHeaderEmptyBag;
    }

    public void clickOnRemoveFromShoppingBagButton() {
        for (WebElement toRemoveButtons : removeFromShoppingBagButton
        ) {
            toRemoveButtons.click();
        }
    }

    public String getMassageThatBagIsEmpty() {
        return massageHeaderEmptyBag.getText();
    }

    public List<String> getTextFromProductDescriptionInBag() {
        List<String> listOfProductsText = new ArrayList<>();
        for (WebElement webElement : getTextFromProductDescriptionInBag
        ) {
            listOfProductsText.add(webElement.getText());
        }
        return listOfProductsText;
    }

    public WebElement getWaitToLoadDescriptionOfProduct() {
        return waitToLoadDescriptionOfProduct;
    }
}
