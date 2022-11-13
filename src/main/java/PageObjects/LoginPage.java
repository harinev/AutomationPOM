package PageObjects;

import com.sun.jna.WString;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement usernameTxtField;


    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTxtField;

    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement validationLoginMsg;

    public void enterUsername(String usernameVal)
    {
        usernameTxtField.sendKeys(usernameVal);

    }
    public void enterPassword(String passwordVal)
    {
        passwordTxtField.sendKeys(passwordVal);

    }
    public void clickbtn()
    {
        loginBtn.click();
    }
    public void verifyInvalidLogin(String validationMsg)
    {
        Assert.assertEquals(validationMsg, validationLoginMsg.getText());
    }
}
