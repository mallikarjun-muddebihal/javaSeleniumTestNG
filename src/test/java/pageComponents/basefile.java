package pageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class basefile  {
    public static WebDriver driver;
    @BeforeClass
    public void initBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void killBrowser() {
        driver.quit();
    }
}