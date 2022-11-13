package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    public CheckOutPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
