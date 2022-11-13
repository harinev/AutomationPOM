package stepDefinitions;

import PageObjects.LoginPage;
import functionLibrary.CommonFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps extends CommonFunctions {

    LoginPage loginPage= new LoginPage(driver);
    @Given("I am on home page {string} with title as {string}")
    public void openHomePage(String url, String expectedHomePageTitle) {

        driver.get(url);
        Assert.assertEquals(expectedHomePageTitle, driver.getTitle());
    }

    @When("I enter username {string} and password {string}")
    public void userName(String username, String password) {
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    }

    @And("I click login button")
    public void login() {

    loginPage.clickbtn();

    }

    @Then("I should get re-directed to products page with Heading {string}")
    public void checkReDirection(String expectedPageHeading) {

        Assert.assertEquals(expectedPageHeading, driver.findElement(By.className("title")).getText());
    }

    @Then("I should not be allowed to login instead {string}")

    public void verifyWithInvalid(String expectedErrorMsg) {
    loginPage.verifyInvalidLogin(expectedErrorMsg);
    }

}
