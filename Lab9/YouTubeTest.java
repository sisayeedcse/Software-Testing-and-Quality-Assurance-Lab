import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class YouTubeTest {
    ChromeDriver driver;
    @Test
    public void YoutubeTest(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.youtube.com/");
        driver.findElement(By.name("search_query")).sendKeys("Java Testing");
        driver.findElement(By.className("ytSearchboxComponentSearchButton")).click();
    }
}
