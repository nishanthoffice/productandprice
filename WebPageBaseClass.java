package webPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebPageBaseClass {
    public String url = "http://automationpractice.com/index.php";
    static WebDriver driver;

    @BeforeClass
    public void Setup() {
        System.setProperty("webDriver.chrome.driver", "D:\\chromedriver_win32 (3).exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @AfterClass
    public void TearDown() {
        driver.quit();
    }
}