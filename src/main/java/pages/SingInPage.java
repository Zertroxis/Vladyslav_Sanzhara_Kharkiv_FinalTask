package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingInPage extends BasePage{

    @FindBy(xpath = "//span[@id = 'EmailAddress-error']")
    private WebElement errorMassageToUserAboutIncorrectDataInEmailField;

    @FindBy(xpath = "//div/input[@value='Sign in']")
    private WebElement singInUpButton;

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordField;

    public SingInPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSingInUpButton(){
        singInUpButton.click();
    }

    public String getTextErrorInEmailField(){
        return errorMassageToUserAboutIncorrectDataInEmailField.getText();
    }

    public String getTextFromEmailField(){
        return emailField.getText();
    }

    public String getTextFromPasswordField(){
        return passwordField.getText();
    }

}
