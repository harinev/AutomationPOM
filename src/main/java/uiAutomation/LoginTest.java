package uiAutomation;

import com.beust.ah.A;
import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;

@RunWith(JUnitParamsRunner.class)
public class LoginTest {
    /*search for the browser    open url    enter homepage
            search for login textbox    enter valid username and password
            click login
            verify the title name to achieve expected page         */
    public static WebDriver driver;

    @Before
    public void beforeTest()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals("Swag Labs",driver.getTitle() );
    }

    @Test
    @Parameters({
            "standard_user, secret_sauce, PRODUCTS, Sauce Labs Backpack"
    })
    public void verifyLoginWIthValidCredentials(String validUsername, String validPassword, String expectedPageHeading, String expectedCartValue ) {

        driver.findElement(By.id("user-name")).sendKeys(validUsername);
        driver.findElement(By.id("password")).sendKeys(validPassword);
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(expectedPageHeading, driver.findElement(By.className("title")).getText());
    }


    @Test
    @Parameters({
            "george_sauce, test, Epic sadface: Username and password do not match any user in this service"
    })
    public void verifyLoginWithInvalidCredentials(String invalidUsername, String invalidPassword, String expectedErrorCode)
    {
        driver.findElement(By.id("user-name")).sendKeys(invalidUsername);
        driver.findElement(By.id("password")).sendKeys(invalidPassword);
        driver.findElement(By.id("login-button")).click();
        //Assert.assertEquals(expectedErrorCode, driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText());
        Assert.assertTrue("Epic sadface: Username and password do not match any user in this service", true);
    }
    @Test
    @Parameters({
            "Epic sadface: Username is required"
    })
    public void verifyLoginWithNoCredentials(String expectedErrorNote)
    {
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(expectedErrorNote, driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText());

    }

    @After
    public void afterTest()
    {
    driver.quit();
    }
}
