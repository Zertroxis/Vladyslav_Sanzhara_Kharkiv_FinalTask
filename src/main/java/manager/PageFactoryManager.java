package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public HelpAndFAQs getHelpAndFAQs() {
        return new HelpAndFAQs(driver);
    }

    public ShoppingBagPage getShoppingBagPage() {
        return new ShoppingBagPage(driver);
    }

    public WishlistPage getWishlistPage() {
        return new WishlistPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public DeliveryAndReturnPage getDeliveryAndReturnPage() {
        return new DeliveryAndReturnPage(driver);
    }

    public ListOfCategoryProductsPage getListOfCategoryProductsPage() {
        return new ListOfCategoryProductsPage(driver);
    }

    public SingInPage getSingInPage() {
        return new SingInPage(driver);
    }
}
