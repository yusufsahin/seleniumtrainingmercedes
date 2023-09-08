package tr.com.mercedesbenz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SportsStoreOrder {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp()
    {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("http://sportsstore.innovium.net/");
    }

    @Test
    public void sportsStoreE2E() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("Home")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".card:nth-child(1) h4"));
           Assertions.assertTrue(elements.size() > 0);
        }
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/div[2]/div[2]/div[1]/div/h4/span/small"), "$275.00"));
            wait.until(ExpectedConditions.textToBe(By.cssSelector("div.card:nth-child(1) > div:nth-child(1) > h4:nth-child(1) > span:nth-child(1) > small:nth-child(1)"), "$275.00"));

         //   div.card:nth-child(1) > div:nth-child(1) > h4:nth-child(1) > span:nth-child(1) > small:nth-child(1)

          //  html body div.row.m-1.p-1 div.col-9 div.card.card-outline-primary.m-1.p-1 div.bg-faded.p-1 h4 span.badge.rounded-pill.bg-primary.text-white small
        }
        driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
        driver.findElement(By.cssSelector("h2")).click();
        driver.findElement(By.cssSelector("h2")).click();
        driver.findElement(By.cssSelector(".text-right:nth-child(2)")).click();
        driver.findElement(By.linkText("Checkout")).click();
        driver.findElement(By.cssSelector("h2")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.textToBe(By.cssSelector("h2"), "Check out now"));
        }
        driver.findElement(By.id("Name")).click();
        driver.findElement(By.id("Name")).sendKeys("John Doe");
        driver.findElement(By.id("Line1")).click();
        driver.findElement(By.id("Line1")).sendKeys("Main Blv");
        driver.findElement(By.id("Line2")).click();
        driver.findElement(By.id("Line2")).sendKeys("5432 Str");
        driver.findElement(By.id("Line3")).click();
        driver.findElement(By.id("Line3")).sendKeys("No 5");
        driver.findElement(By.id("City")).click();
        driver.findElement(By.id("City")).sendKeys("Austin,Texas");
        driver.findElement(By.id("State")).click();
        driver.findElement(By.id("State")).sendKeys("TX");
        driver.findElement(By.id("Zip")).click();
        driver.findElement(By.id("Zip")).sendKeys("34567");
        driver.findElement(By.id("Country")).click();
        driver.findElement(By.id("Country")).sendKeys("USA");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        Assertions.assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Thanks!");
        driver.findElement(By.linkText("Return to Store")).click();
    }

    @AfterEach
    public void tearDown()
    {
        driver.quit();
    }

}
