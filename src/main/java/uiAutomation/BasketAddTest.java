package uiAutomation;

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

import java.util.concurrent.TimeUnit;

@RunWith(JUnitParamsRunner.class)
public class BasketAddTest {


    public static WebDriver driver;


    @Before

    public void beforeTest()
    {
        //open url


        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals("Swag Labs",driver.getTitle() );
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals("PRODUCTS", driver.findElement(By.className("title")).getText());
    }
    @Test
    @Parameters( {
    "Sauce Labs Bolt T-Shirt"
    })
    public void addToBasket(String expectedCartValue) {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();

        driver.findElement(By.className("shopping_cart_link")).click();
        Assert.assertTrue(driver.findElement(By.className("inventory_item_name")).isDisplayed());
        System.out.println("added to cart ok");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }



    @After
    public void afterTest(){
        driver.quit();
    }
}
