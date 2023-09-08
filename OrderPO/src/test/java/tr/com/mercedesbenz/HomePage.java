package tr.com.mercedesbenz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public  void  selectProduct()
    {
        driver.findElement(By.linkText("Home"));
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card:nth-child(1) h4")));
        }
    }

    public  void addToCart()
    {
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/div[2]/div[2]/div[1]/div/h4/span/small"), "$275.00"));
            wait.until(ExpectedConditions.textToBe(By.cssSelector("div.card:nth-child(1) > div:nth-child(1) > h4:nth-child(1) > span:nth-child(1) > small:nth-child(1)"), "$275.00"));

            //   div.card:nth-child(1) > div:nth-child(1) > h4:nth-child(1) > span:nth-child(1) > small:nth-child(1)

            //  html body div.row.m-1.p-1 div.col-9 div.card.card-outline-primary.m-1.p-1 div.bg-faded.p-1 h4 span.badge.rounded-pill.bg-primary.text-white small
        }
        driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
        }
    }

    public void goToCheck() {
        driver.findElement(By.linkText("Checkout")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
        }
    }
}
