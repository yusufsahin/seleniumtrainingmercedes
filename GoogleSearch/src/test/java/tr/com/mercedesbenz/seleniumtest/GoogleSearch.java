package tr.com.mercedesbenz.seleniumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearch {

    private WebDriver driver;

    @Test
    public void search()
    {
        driver= new FirefoxDriver();
        driver.get("https://www.google.com.tr");

        System.out.println(driver.getTitle());
        //System.out.println(driver.getPageSource());
        // driver.navigate().refresh();

      ///  WebElement searchBox =driver.findElement(By.name("q"));
///html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]
        WebElement searchBox =driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]"));

        searchBox.sendKeys("Mercedes Benz");

        searchBox.submit();

        ///driver.navigate().refresh();



        //driver.quit();
    }

}
