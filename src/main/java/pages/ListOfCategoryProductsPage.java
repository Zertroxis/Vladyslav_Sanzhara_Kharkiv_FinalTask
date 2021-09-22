package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ListOfCategoryProductsPage extends BasePage {

    @FindBy(xpath = "//div[@data-auto-id = 'productList']//article[@data-auto-id='productTile']/a/div/div/div/p")
    private List<WebElement> listOfProductsOnPage;

    @FindBy(xpath = "//article")
    private List<WebElement> getProductOnPage;

    @FindBy(xpath = "//button[@aria-haspopup='true']/div[text()='Gender']")
    private WebElement filterProductsByGender;

    @FindBy(xpath = "//div[text()='Men']")
    private WebElement filterProductsByGenderMen;

    @FindBy(xpath = "//button[@aria-haspopup='true']/div[text()='Product Type']")
    private WebElement filterProductsByProductType;

    @FindBy(xpath = "//div[text()='Boots']")
    private WebElement filterProductsByProductTypeBoots;

    @FindBy(xpath = "//div[@class='_2MoInDZ']")
    private WebElement waitToLoadSectionWithMartensBoots;

    @FindBy(xpath = "//button[@type='button'][@data-auto-id='saveForLater']")
    private List<WebElement> addToWishlistFromCategoryCatalogOfProduct;

    @FindBy(xpath = "//section/h2[@class='grid-text__title ']")
    private WebElement textThatNothingMatchesAfterSearch;

    public ListOfCategoryProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> webElementListContainsText() {
        List<String> listOfProductsText = new ArrayList<>();
        for (WebElement webElement : listOfProductsOnPage
        ) {
            listOfProductsText.add(webElement.getText());
        }
        return listOfProductsText;
    }

    public void clickOnFirstProductOnPage() {
        getProductOnPage.get(0).click();
    }

    public void clickOnFilterProductsByGender() {
        filterProductsByGender.click();
    }

    public void clickOnFilterProductsByMan() {
        filterProductsByGenderMen.click();
    }

    public void clickOnFilterProductType() {
        filterProductsByProductType.click();
    }

    public void clickOnFilterProductTypeBoots() {
        filterProductsByProductTypeBoots.click();
    }

    public void clickOnSecondDrMartensBoots() {
        getProductOnPage.get(1).click();
    }

    public WebElement getWaitToLoadSectionWithMartensBoots() {
        return waitToLoadSectionWithMartensBoots;
    }

    public void clickOnFirstProductFromCategoryProductsToWishlist() {
        addToWishlistFromCategoryCatalogOfProduct.get(0).click();
    }

    public WebElement scrollToElementSecondDrMartensBoots() {
        return getProductOnPage.get(1);
    }

    public void clickOnThirdProductToOpenFromCategoryProducts() {
        getProductOnPage.get(2).click();
    }

    public WebElement waitToLoadNotingMatchesAfterSearch() {
        return textThatNothingMatchesAfterSearch;
    }

    public String getTextFromHeaderTwoNothingMatchesAfterSearch() {
        return textThatNothingMatchesAfterSearch.getText();
    }
}
