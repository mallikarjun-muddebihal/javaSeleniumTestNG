package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageComponents.basefile;

public class LoginTest extends basefile{
    @Test(priority = 1)
    public void openPage() {
        driver.get("https://www.selenium.dev/");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle.toLowerCase().trim(), "selenium");
    }
}
