package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InstagramPage {
    public InstagramPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameKutusu;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[text()='Log In']")
    public WebElement loginKutusu;

    @FindBy(xpath = "//button[text()='Not Now']")
    public WebElement notNowKutusu;

    @FindBy(xpath = "//button[@class='_a9-- _a9_1']")
    public WebElement notNowKutusu2;

    @FindBy(xpath = "//img[@class='_aa8j'][1]")
    public WebElement profilKutusu;


}
