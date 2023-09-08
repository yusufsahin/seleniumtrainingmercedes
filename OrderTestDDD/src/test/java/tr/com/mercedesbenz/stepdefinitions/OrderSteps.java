package tr.com.mercedesbenz.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import tr.com.mercedesbenz.HomePage;
import tr.com.mercedesbenz.OrderPage;

import java.time.Duration;

public class OrderSteps {
    /*
    Feature: Placing order on sportsstore
    Scenario: User places an order
    Given User is on sportsstore homepage
    When  User clicks on Chess category
    And User adds Think cap to the cart
    And User proceeds to checkout
    And User fills order information
    Then User should see order confirmation message

    */

    private WebDriver driver;
    private HomePage homePage;
    private OrderPage orderPage;

    @Given("User is on sportsstore homepage")
    public void user_is_on_sportsstore_homepage()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net/");

        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);

    }
    @When("User clicks on Chess category")
    public void user_clicks_on_Chess_category()
    {
        homePage.selectCategory("Chess");
    }

    @And("User adds Think cap to the cart")
    public void   user_adds_Think_cap_to_the_cart()
    {
        homePage.addtoCart(1);
    }

    @And("User proceeds to checkout")
    public void user_proceeds_to_checkout()
    {
        homePage.goToCheckout();
    }
    @And("User fills order information")
    public void use_fills_order_information(){
        orderPage.enterDetails("John Doe", "ABC Bulv.", "996677 Str.", "No:10", "New York", "NY", "456677", "USA");
    }
    @Then("User should see order confirmation message")
    public  void user_should_see_order_confirmation_message(){
        orderPage.submitOrder();
        Assert.assertEquals(orderPage.getConfirmationText(),"Thanks!");
        //orderPage.returnToStore();
        //driver.quit();

    }
    @Then("Return To Store")
    public void return_To_Store()
    {
        orderPage.returnToStore();
        //driver.quit();
    }


}
