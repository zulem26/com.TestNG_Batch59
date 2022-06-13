package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath="//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucElementi;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement signButonYanas;

    @FindBy(xpath = "//*[text()='Sign in'][1]")
    public WebElement signInButon;

    @FindBy(xpath = "//input[@id='ap_email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement devamButon;

    @FindBy(xpath = "//h4")
    public WebElement uyariMesaji;

    @FindBy(xpath = "//span[@class='a-expander-prompt']")
    public WebElement yardimYazisi;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword;

    @FindBy(xpath = "//h1")
    public WebElement passwordAssistance;

    @FindBy(id = "createAccountSubmit")
    public WebElement createAccountButton;

    @FindBy(xpath = "//h1")
    public WebElement createAccountText;

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    public WebElement nameButton;

    @FindBy(xpath = "//input[@id='ap_email']")
    public WebElement emailGonder;

    @FindBy(xpath = "//input[@id='ap_password']")
    public WebElement passWordKutusu;

    @FindBy(xpath = "//input[@id='ap_password_check']")
    public WebElement passwordCheck;

    @FindBy(xpath = "//input[@class='a-button-input']")
    public WebElement devamButonu;
}
