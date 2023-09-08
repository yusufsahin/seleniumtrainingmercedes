package tr.com.mercedesbenz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class OrderTest {
    private WebDriver driver;
    private HomePage homePage;
    private OrderPage orderPage;

    @BeforeEach
    public void setUp() {
        driver = createWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net/");

        // Initialize the HomePage using Page Factory
        homePage = new HomePage(driver);
        orderPage= new OrderPage(driver);

    }

    @Test
    public void order() {
        homePage.selectProduct();
        homePage.addToCart();
        homePage.goToCheckOut();
        orderPage.enterDetails("John Doe", "Main Blv", "5432 Str", "No 5", "Austin,Texas", "TX", "34567", "USA");
        orderPage.submitOrder();
        Assertions.assertEquals(orderPage.getConfirmationText(),"Thanks!");
        orderPage.returnToStore();
    }

    private WebDriver createWebDriver() {
        // You can customize this method to create the WebDriver instance you need
        return new FirefoxDriver();
    }
}
