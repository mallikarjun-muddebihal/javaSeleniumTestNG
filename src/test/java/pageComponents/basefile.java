package pageComponents;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class basefile  {
    public static WebDriver driver;
    @BeforeClass
    public void initBrowser() {
                ChromeOptions options = new ChromeOptions();
        
        // Disable all extensions (including ad blockers already installed)
        options.addArguments("--disable-extensions");
        
        // Additional options to minimize unwanted content
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 800));
        driver.manage().window().maximize();
    }
    @AfterClass
    public void killBrowser() {
        driver.quit();
    }
}