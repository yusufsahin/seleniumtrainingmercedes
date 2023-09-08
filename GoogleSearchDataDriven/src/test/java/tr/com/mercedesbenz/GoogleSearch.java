package tr.com.mercedesbenz;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

public class GoogleSearch {

    private WebDriver driver;
    private Workbook workbook;

    @BeforeEach
    private  void  setup() throws IOException {
        ChromeOptions options= new ChromeOptions();
       // options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com.tr");
        FileInputStream fis= new FileInputStream(new File("src/test/resources/data.xlsx"));
        workbook= new XSSFWorkbook(fis);
    }

    @Test
    @DisplayName("Perform Google Search Test")
    public void performGoogleSearchTest() throws InterruptedException {
        Sheet sheet= workbook.getSheetAt(0);
        Iterator<Row> rowIterator= sheet.iterator();

        if(rowIterator.hasNext())
        {
            rowIterator.next();
        }

        while(rowIterator.hasNext()){
            Row row= rowIterator.next();
            Cell cell= row.getCell(0);
            String searchQuery= cell.getStringCellValue();

            WebElement searchBox= driver.findElement(By.name("q"));

            searchBox.clear();
            searchBox.sendKeys(searchQuery);
            searchBox.submit();

            Thread.sleep(3000);

            String expectedTitle=searchQuery+ " - Google'da Ara";
            String actualTitle= driver.getTitle();

            Assertions.assertEquals(expectedTitle,actualTitle);
        }

    }

    @AfterEach
    public void tearDown() {
        if (driver!=null)
        {
            driver.quit();
        }
    }

}
