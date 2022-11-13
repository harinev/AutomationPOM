package stepDefinitions;

import PageObjects.BasketPage;
import functionLibrary.CommonFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class BasketSteps extends CommonFunctions {

    BasketPage basketPage= new BasketPage(driver);
    @When("I add {string} to the cart")

    public void addToCart(String product){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
    }

    @And("click on basket shopping_cart_link")
    public void clickShoppingCartLink(){
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("I should see {string} in the bag")
    public void verifyAProductInBag(String expectedItemInBag1){
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='"+expectedItemInBag1+"']")).isDisplayed());

    }
    @Then("I should see {string} and {string} and {string} in the bag")
    public void verifyProductsInBag(String expectedItemInBag1, String expectedItemInBag2, String expectedItemInBag3){


        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='"+expectedItemInBag1+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='"+expectedItemInBag2+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='"+expectedItemInBag3+"']")).isDisplayed());
    }


    @When("I click bag icon")
    public void i_click_bag_icon() {
        basketPage.clickCartICon();
    }

    @When("I click remove button from the bag")
    public void i_click_remove_button_from_the_bag() {
    basketPage.removeBtn();
    }

    @Then("I should not see the {string} in my cart")
    public void i_should_not_see_the_in_my_cart(String expectedItemInBag) {
    basketPage.assertRemove(expectedItemInBag);
    }
}
