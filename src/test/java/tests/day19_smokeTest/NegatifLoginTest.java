package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegatifLoginTest {

    BrcPage brcPage;


    @Test
    public void yanlisSifre() {
        brcPage = new BrcPage();
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        brcPage.ilkLoginButonu.click();

        // test data user email: customer@bluerentalcars.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        // test data password : 54321
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        // login butonuna tiklayiniz
        brcPage.ikinciLoginButonu.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();

        // bu class da 2 test methodu daha olusturun
        // biri yanlisKullanici
        // diegeri yanlis sifre ve kullanici adi


    }
    @Test
    public void yanlisKullanici() {
        brcPage = new BrcPage();
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        brcPage.ilkLoginButonu.click();

        // test data user email: yanlis kullanici adi ile giris
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        // login butonuna tiklayiniz
        brcPage.ikinciLoginButonu.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void yanlisSifreYanlisKullanici() {
        brcPage = new BrcPage();
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        brcPage.ilkLoginButonu.click();

        // test data user email: yanlis kullanici adi ile giris
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        // test data password : yanlis sifre ile giris 54321
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        // login butonuna tiklayiniz
        brcPage.ikinciLoginButonu.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());

    }
}
