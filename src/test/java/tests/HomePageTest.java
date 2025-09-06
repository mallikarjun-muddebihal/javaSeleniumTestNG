package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageComponents.basefile;
import pageComponents.helper.helper;
import pageComponents.pages.HomePage;
public class HomePageTest extends basefile{
    helper objHelper = new helper();
    HomePage objHomePage = new HomePage();
    @Test(groups = {"inputBox"}, priority = 1)
    public void fillUserDetails() {
        driver.get("http://testautomationpractice.blogspot.com/#");
        String pageTitle =  driver.getTitle();
        Assert.assertEquals(pageTitle.toLowerCase().trim(), "Automation Testing Practice".toLowerCase());
        String name = objHelper.setValueToInputBox("name", "user1");
        Assert.assertEquals(name, "user1");
        String email = objHelper.setValueToInputBox("email", "user1@gmail.com");
        Assert.assertEquals(email, "user1@gmail.com");
        String phone = objHelper.setValueToInputBox("phone", "9988776655");
        Assert.assertEquals(phone, "9988776655");
    }

    @Test(groups={"radioButtons"}, priority = 2)
    public void selectGenderandDay() {
        boolean genderSelected = objHelper.selectButtonByValue("Male", objHomePage.genderRadioButton);
        Assert.assertTrue(genderSelected);
        boolean daySelected = objHelper.selectButtonByValue("Tuesday", objHomePage.daysCheckBoxes);
        Assert.assertTrue(daySelected);
    }

    @Test(groups = {"Dropdowns"}, priority = 3) 
    public void dropDownTests() {
        String selectedCountry = objHelper.selectCountryFromDropDown("India");
        Assert.assertEquals(selectedCountry.toLowerCase(), "India".toLowerCase());
        String selectedColor = objHelper.selectColor("White");
        Assert.assertEquals(selectedColor.toLowerCase(), "White".toLowerCase());
    }

    @Test(groups = {"DatePicker"}, priority = 4)
    public void selectDates() {
        String selectedDate = objHelper.setValueToInputBox("datepicker", "12/06/2003");
        Assert.assertEquals(selectedDate, "12/06/2003");
        String pickedDate = objHelper.selectDateFromCalender("10", "May", "2018");
        Assert.assertEquals(pickedDate, "10/05/2018");
    }
}
