package tr.com.mercedesbenz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    @FindBy(linkText = "Home")
    private WebElement menuCategory;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addToCartButton;

    @FindBy(linkText = "Checkout")
    private WebElement checkOutButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage(String url) {
        driver.get(url);
    }

    public void selectProduct() {
        menuCategory.click();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void goToCheckOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        checkOutButton.click();
    }
}