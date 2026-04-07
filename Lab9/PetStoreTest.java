import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class PetStoreTest {
    WebDriver driver;

    @BeforeMethod
    @Test
    public void setup() {
        // Selenium 4 automatically manages the driver executable
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
    }
    @Test
    public void testTitleAndLogo() {
        // Verify we are on the right page
        boolean isLogoPresent = driver.findElement(By.xpath("//div[@id='LogoContent']")).isDisplayed();
        Assert.assertTrue(isLogoPresent, "The PetStore logo should be visible.");
    }

    @Test
    public void testSearchFunctionality() {
        WebElement searchBox = driver.findElement(By.name("keyword"));
        WebElement searchButton = driver.findElement(By.name("searchProducts"));
        searchBox.sendKeys("Golden Retriever");
        searchButton.click();
        // Verify the result contains the dog we looked for
        WebElement resultText = driver.findElement(By.xpath("//td[contains(text(),'Golden Retriever')]"));
        Assert.assertNotNull(resultText, "Search results should contain 'Golden Retriever'.");
    }

    @DataProvider(name = "petSearchData")
    public Object[][] searchTerms() {
        return new Object[][] {
                {"Golden Retriever"},
                {"Angelfish"},
                {"Poodle"},
                {"Koi"},
                {"Tiger Shark"}
        };
    }
    @Test(dataProvider = "petSearchData")
    public void testSearchFunctionality(String petName) {
        WebElement searchBox = driver.findElement(By.name("keyword"));
        WebElement searchButton = driver.findElement(By.name("searchProducts"));
        // Clear the box first in case of leftover text
        searchBox.clear();
        searchBox.sendKeys(petName);
        searchButton.click();
        // Verify the result contains the specific pet name
        // We use a dynamic XPath to find the text of the pet we just searched for
        String xpathExpression = "//td[contains(text(),'" + petName + "')]";
        WebElement resultText = driver.findElement(By.xpath(xpathExpression));
        Assert.assertTrue(resultText.isDisplayed(), "Search results should display: " + petName);
    }
    @Test
    public void testCategoryNavigation() {
        // Click on the 'Fish' category quick link
        driver.findElement(By.xpath("//div[@id='QuickLinks']//img[@src='../images/sm_fish.gif']")).click();
        WebElement categoryHeader = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(categoryHeader.getText(), "Fish", "The header should display 'Fish' after navigation.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
