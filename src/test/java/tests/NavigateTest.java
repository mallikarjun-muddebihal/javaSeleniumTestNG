package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageComponents.basefile;
public class NavigateTest extends basefile{
    @Test
    public void help() {
        driver.navigate().to("https://www.accenture.com/in-en");
        String pageTitle =  driver.getTitle();
        Assert.assertEquals(pageTitle.toLowerCase().trim(), "India | Let There Be Change | Accenture".toLowerCase());
    }
}
