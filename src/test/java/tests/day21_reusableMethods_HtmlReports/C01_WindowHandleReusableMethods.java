package tests.day21_reusableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_WindowHandleReusableMethods {
    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH=Driver.getDriver().getWindowHandle();

        //Click Here butonuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        Set<String> windowHandleSeti = Driver.getDriver().getWindowHandles();

        String ikincisayfaWH="";
        for (String each:windowHandleSeti){
            if (!each.equals(ilkSayfaWH)){
                ikincisayfaWH=each;
            }
        }
        Driver.getDriver().switchTo().window(ikincisayfaWH);
        System.out.println(Driver.getDriver().getTitle());

        // acilan yeni TAB in title inin New Window oldugunu test edin
        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test
    public void test02() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        //Click Here butonuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        // acilan yeni TAB in title inin New Window oldugunu test edin
        ReusableMethods.switchToWindow("New Winodow");


        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.closeDriver();
    }
}
