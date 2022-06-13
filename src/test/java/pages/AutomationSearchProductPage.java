package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationSearchProductPage {
    public AutomationSearchProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/products']")
    public WebElement product;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement allProducts;

    @FindBy(xpath = "//input[@id='search_product']")
    public WebElement searchBox;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement searchProductsText;

    @FindBy(xpath = "//button[@id='submit_search']")
    public WebElement searchButton;

    @FindBy(linkText = "View Product")
    public WebElement viewProduct;

    @FindBy(xpath = "(//h2)[3]")
    public WebElement blueTopName;

    @FindBy(xpath = "(//p)[3]")
    public WebElement category;

    @FindBy(xpath = "(//p)[6]")
    public WebElement brand_polo;
}
