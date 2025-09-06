package pageComponents.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pageComponents.pages.HomePage;
import pageComponents.basefile;

public class helper extends basefile{
    HomePage objHomePage = new HomePage();
    public boolean selectButtonByValue(String value, String selector) {
        boolean isGenderSelected = false;
        List<WebElement> buttons = driver.findElements(By.cssSelector(selector));
        for(WebElement button: buttons) {
            String attrVal = button.getAttribute("value");
            if(attrVal.toLowerCase().equals(value.toLowerCase())) {
                button.click();
                isGenderSelected = button.isSelected();
                break;
            }
        }
        return isGenderSelected;
    }

    public String setValueToInputBox(String id, String value) {
        WebElement inputBox = driver.findElement(By.id(id));
        Actions action = new Actions(driver);
        action.click(inputBox).sendKeys(value).build().perform();
        String boxValue = inputBox.getAttribute("value");
        return boxValue;
    }

    public String selectCountryFromDropDown(String value) {
        WebElement dropdownElem = driver.findElement(By.id("country"));
        selectDropdownValueByText(dropdownElem, value);
        return dropdownElem.getAttribute("value");
    }

    public String selectColor(String value) {
        WebElement dropdownElem = driver.findElement(By.id("colors"));
        selectDropdownValueByText(dropdownElem, value);
        return dropdownElem.getAttribute("value");
    }

    public String selectDateFromCalender(String date, String month, String Year) {
        driver.findElement(By.xpath(objHomePage.datePicker2Input)).click();
        WebElement monthDropdown = driver.findElement(By.className("ui-datepicker-month"));
        selectDropdownValueByText(monthDropdown, month);
        WebElement yearDropdown = driver.findElement(By.className("ui-datepicker-year"));
        selectDropdownValueByText(yearDropdown, Year);
        driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']//td/a[text()='"+date+"']")).click();
        return driver.findElement(By.xpath(objHomePage.datePicker2Input)).getAttribute("value");
    }

    public void selectDropdownValueByText(WebElement elem, String value) {
        Select dropdown = new Select(elem);
        dropdown.selectByVisibleText(value);
    }
}
