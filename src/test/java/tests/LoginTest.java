package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageComponents.basefile;
import pageComponents.pages.*;;

public class LoginTest extends basefile{
    LoginPage objLoginPage =new LoginPage();
    @Test(priority = 1, groups = {"Smoke"})
    public void validateLoginPage() {
        driver.get("https://practice.expandtesting.com/login");
        String pageTitle = driver.getTitle();
        String submitButtonText = driver.findElement(By.cssSelector(objLoginPage.submitButton)).getText();
        Assert.assertTrue(pageTitle.toLowerCase().trim().contains("test login page"));
        Assert.assertEquals(submitButtonText.toLowerCase().trim(), "login");
    }

    @Test(priority=2)
    public void invalidLogin() {
        String usernamame = "dcdc dcpwkd";
        String password = "ASSWPRD";
        login(usernamame, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(objLoginPage.errorMessage)));
        String errorMessage = driver.findElement(By.cssSelector(objLoginPage.errorMessage)).getText();
        Assert.assertEquals(errorMessage, "Your username is invalid!");
        driver.findElement(By.cssSelector(objLoginPage.errorMessage+"~button")).click();
    }

    @Test(priority = 3)
    public void validLogin() {
        List<WebElement> credentials = driver.findElements(By.cssSelector(objLoginPage.credentials));
        String username = credentials.get(0).getText();
        String password = credentials.get(1).getText();
        login(username, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        String pageTitle = driver.getTitle();
        String loggedInUser = driver.findElement(By.id("username")).getText();
        Assert.assertTrue(pageTitle.toLowerCase().trim().contains("secure page"));
        Assert.assertEquals(loggedInUser.toLowerCase().trim(), "hi, "+username+"!");
    }

    @Test(priority = 4)
    public void signOut() {
        WebElement signOutButton = driver.findElement(By.xpath("//i[contains(text(), 'Logout')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",signOutButton);
        String pageTitle = driver.getTitle();
        String submitButtonText = driver.findElement(By.cssSelector(objLoginPage.submitButton)).getText();
        Assert.assertTrue(pageTitle.toLowerCase().trim().contains("test login page"));
        Assert.assertEquals(submitButtonText.toLowerCase().trim(), "login");
    }

    public void login(String username, String password) {
        WebElement usernameBox = driver.findElement(By.id(objLoginPage.userNameBox));
        Actions action = new Actions(driver);
        action.scrollToElement(usernameBox);
        driver.findElement(By.id(objLoginPage.userNameBox)).sendKeys(username);
        driver.findElement(By.id(objLoginPage.passwordBox)).sendKeys(password);
        WebElement submitButton = driver.findElement(By.cssSelector(objLoginPage.submitButton));
        //action.scrollToElement(submitButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitButton);
        js.executeScript("arguments[0].click();", submitButton);
        //driver.findElement(By.cssSelector(objLoginPage.submitButton)).click();
    }
}
