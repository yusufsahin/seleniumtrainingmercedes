package tr.com.mercedesbenz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    @FindBy(id = "Name")
    private WebElement nameInput;

    @FindBy(id = "Line1")
    private WebElement line1Input;

    @FindBy(id = "Line2")
    private WebElement line2Input;

    @FindBy(id = "Line3")
    private WebElement line3Input;

    @FindBy(id = "City")
    private WebElement cityInput;

    @FindBy(id = "State")
    private WebElement stateInput;

    @FindBy(id = "Zip")
    private WebElement zipInput;

    @FindBy(id = "Country")
    private WebElement countryInput;

    @FindBy(css = ".btn-primary")
    private WebElement submitButton;

    @FindBy(css = "h2")
    private WebElement confirmationText;

    @FindBy(linkText = "Return to Store")
    private WebElement returnToStoreLink;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void enterDetails(String name, String line1, String line2, String line3, String city, String state, String zip, String country) {
        nameInput.click();
        nameInput.sendKeys(name);
        line1Input.click();
        line1Input.sendKeys(line1);
        line2Input.click();
        line2Input.sendKeys(line2);
        line3Input.click();
        line3Input.sendKeys(line3);
        cityInput.click();
        cityInput.sendKeys(city);
        stateInput.click();
        stateInput.sendKeys(state);
        zipInput.click();
        zipInput.sendKeys(zip);
        countryInput.click();
        countryInput.sendKeys(country);
    }

    public void submitOrder() {
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
    }

    public String getConfirmationText() {
        return confirmationText.getText();
    }

    public void returnToStore() {
        returnToStoreLink.click();
    }
}
