package tests.practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WikiPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;
import utilities.TestBaseRapor;

import java.util.List;

public class Q7_WebTableTest extends TestBaseRapor {

     /*
   go to url : https://en.wikipedia.org/wiki/Dell
   go to table which name is 'List of companies acquired by Dell Inc.'
   print row 4 of the table on console
   also print on console the 2nd and 3rd elements (middle 2 elements) in line 5
   ( 2nd and 3rd elements : November 2, Cloud integration leader)
     Verify that Compellent appears in the first cell of line 6

   url'ye gidin: https://en.wikipedia.org/wiki/Dell
    'List of companies acquired by Dell Inc.' isimli tabloya gidin,
    tablonun 4. satırını konsolda yazdırın
    ayrıca 5. satırdaki 2. ve 3. öğeleri (ortadaki 2 öğe) konsola yazdırın
    ( 2nd and 3rd ogeler : November 2, Cloud integration leader)
    6. satirin ilk hucresinde Compellent yazisinin goruntulendigini dogrulayin

    */
    @Test
    public void test01(){

        extentTest = extentReports.createTest("wikipedia webtable test", "table test");
        WikiPage wikipage = new WikiPage();

        Driver.getDriver().get(ConfigReader.getProperty("wikiUrl"));
        extentTest.info("istenilen url e gidildi");

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", wikipage.nameOfList);

        System.out.println("4.satir : " + wikipage.fourthRow.getText());
        extentTest.info("4.satir consol a yazildi");


        System.out.println("5.satir 2.element :" + wikipage.secondElement.getText());
        extentTest.info("5.satir 2.element consol a yazildi");

        System.out.println("5.satir 3.element :" + wikipage.thirdElement.getText());
        extentTest.info("5.satir 3.element consol a yazildi");

        Assert.assertTrue(wikipage.sixthElement.isDisplayed());
        extentTest.pass("Compellent yazi goruldu");
        /*
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(wikipage.tableYeri, Keys.PAGE_DOWN).perform();

        WebElement dorduncuSatir = wikipage.dorduncuSatir;
        System.out.println(wikipage.dorduncuSatir.getText());
         */


    }
}
