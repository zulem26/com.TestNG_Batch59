package tests.instagram;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InstagramPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PositiveLoginTest extends TestBaseRapor{

    @DataProvider
    public static Object[][] validEmailPassword() {
        Object[][] emailPassword={{"testngkontrol1@hotmail.com", "studentsession1"},
                {"batchselenium@hotmail.com", "studentsession2"}};
        return emailPassword;
    }

    @Test(dataProvider = "validEmailPassword")
    public void positiveLoginTest(String validEmail, String validPassword) throws IOException {
        extentTest = extentReports.createTest("Positive Login Test", "Valid Email ve Password ile giris yapabilmeli");
        InstagramPage instagramPage = new InstagramPage();
        // instagram ansayfasina giris yap
        Driver.getDriver().get(ConfigReader.getProperty("instagramUrl"));
        extentTest.info("instagram ansayfasina gidildi");

        // dogru username ve dogru password bilgileri gir
        instagramPage.usernameKutusu.sendKeys(validEmail);
        extentTest.info("username kutusuna validEmail girildi");

        instagramPage.passwordKutusu.sendKeys(validPassword);
        extentTest.info("password kutusuna validPassword girildi");
        // eger login butonu tiklanabilir olursa tikla
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(instagramPage.loginKutusu));
        instagramPage.loginKutusu.click();
        extentTest.info("login butonu tiklanabilir oldugunda butona tiklandi");

        // "Save Your Login Ingor?" yazisinda "Not Now" butonuna tikla
        instagramPage.notNowKutusu.click();
        extentTest.info("not nov butonuna tiklandi");

        // "Turn on Notifications" yazisinda "Not Now" butonuna tikla
        instagramPage.notNowKutusu2.click();
        extentTest.info("not now butonuna tiklandi");

        // giris yapildigini fotografli sekilde dogrula ve rapor belirt

        wait.until(ExpectedConditions.visibilityOf(instagramPage.profilKutusu));
        instagramPage.profilKutusu.click();
        extentTest.info("profil butonuna tiklandi");

        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"));
        File tumSayfa = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfa, new File("target/instagram/tumSayfa"+date+".jpeg"));
        extentTest.info("ekran goruntusu alindi");
        // sayfayi kapat


    }
}
