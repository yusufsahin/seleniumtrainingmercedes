package tr.com.mercedesbenz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class OrderTest {

    private  WebDriver driver;

    HomePage homePage;
    OrderPage orderPage;

    @BeforeEach
    public void  setUp()
    {
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net/");

        homePage = new HomePage(driver);
        orderPage= new OrderPage(driver);
    }
    @Test
    public void order(){
        homePage.selectProduct();
        homePage.addToCart();
        homePage.goToCheck();
        orderPage.enterDetails();
        orderPage.submitOrder();
        Assertions.assertEquals(orderPage.getConfirmationText(),"Thanks!");
        orderPage.returnToStore();
    }
}
