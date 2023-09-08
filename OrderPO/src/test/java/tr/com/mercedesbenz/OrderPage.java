package tr.com.mercedesbenz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterDetails() {
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
    }

    public void submitOrder() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
    }

    public String getConfirmationText() {
        return driver.findElement(By.cssSelector("h2")).getText();
    }

    public void returnToStore() {
        driver.findElement(By.linkText("Return to Store")).click();
    }
}
