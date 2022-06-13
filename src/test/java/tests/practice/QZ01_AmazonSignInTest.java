package tests.practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class QZ01_AmazonSignInTest {

    AmazonPage amazonPage;
    @Test
    public void test01(){
        amazonPage = new AmazonPage();
        Faker faker = new Faker();

        String fakeMail=faker.internet().emailAddress();
        String passWord=faker.internet().password(6,8);
        //Go to the Amazon website
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Click on signInButton
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(amazonPage.signButonYanas).perform();
        amazonPage.signInButon.click();

        // Send e mail by using faker
        amazonPage.emailKutusu.sendKeys(fakeMail);

        // Click on continue
        amazonPage.devamButon.click();

        //Assert "There was a problem" message
        String expectedYazi = "There was a problem";
        String actualYazi = amazonPage.uyariMesaji.getText();
        Assert.assertEquals(actualYazi,expectedYazi);

        // Click on "Need help?"
        amazonPage.yardimYazisi.click();

        // Click on "Forgot your Password?"
        amazonPage.forgotPassword.click();

        //Verify the text "Password assistance"
        Assert.assertTrue(amazonPage.passwordAssistance.isDisplayed());

        //Navigate back
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();

        //Click on "Create your account" button
        amazonPage.createAccountButton.click();

        // Verify the text "Create account"
        String expectedAccount = "Create account";
        String actualAccount = amazonPage.createAccountText.getText();
        Assert.assertEquals(actualAccount,expectedAccount);

        amazonPage.nameButton.sendKeys(faker.name().fullName());

        amazonPage.emailGonder.sendKeys(fakeMail);
        amazonPage.passWordKutusu.sendKeys(passWord);
        amazonPage.passwordCheck.sendKeys(passWord);
        amazonPage.devamButon.click();



    }
}
