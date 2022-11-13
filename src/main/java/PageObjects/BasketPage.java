package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {

    public WebDriver driver;
    public BasketPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(className ="shopping_cart_link" )
    public WebElement cartIcon;

    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement removeBtn;

    public void clickCartICon()
    {
        cartIcon.click();
    }

    public void removeBtn()
    {
        cartIcon.click();
    }

    public void assertRemove(String expectedProductRemoved)
    {
        Assert.assertFalse(driver.getPageSource().contains(expectedProductRemoved));
    }
}
