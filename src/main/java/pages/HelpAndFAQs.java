package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HelpAndFAQs extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'International deliveries')]")
    private WebElement openInternationalDeliveriesPageButton;

    @FindBy(xpath = "//div[@class= 'HtmlContent_content']/p")
    private List<WebElement> contentOnInternationalDeliveriesPage;

    @FindBy(xpath = "//a[text()='Delivery & returns']")
    private WebElement openDeliveryAndReturnsPageButton;

    public HelpAndFAQs(WebDriver driver) {
        super(driver);
    }

    public void clickOnInternationalDeliveriesPageButton(){
        openInternationalDeliveriesPageButton.click();
    }

    public List<String> getTextFromInternationalDeliveryContent() {
        List<String> listOfTextContent = new ArrayList<>();
        for (WebElement webElement : contentOnInternationalDeliveriesPage
        ) {
            listOfTextContent.add(webElement.getText());
        }
        return listOfTextContent;
    }

    public void clickOnOpenDeliveryAndReturnsPageButton(){
        openDeliveryAndReturnsPageButton.click();
    }

}
