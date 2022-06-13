package tests.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationSearchProductPage;
import utilities.ConfigReader;
import utilities.Driver;

public class QZ02_AutomationSearchProduct {

    AutomationSearchProductPage automationSearchProductPage;
    @Test
    public void test01(){
        automationSearchProductPage = new AutomationSearchProductPage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        //3. Verify that home page is visible successfully
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.automationexercise.com/");

        //4. Click on 'Products' button
        automationSearchProductPage.product.click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(automationSearchProductPage.allProducts.isDisplayed());

        //6. Enter product name in search input and click search button
        automationSearchProductPage.searchBox.sendKeys("Blue Top");
        automationSearchProductPage.searchButton.click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(automationSearchProductPage.searchProductsText.isDisplayed());
        automationSearchProductPage.viewProduct.click();

        //8. Verify all the products related to search are visible
        Assert.assertTrue(automationSearchProductPage.blueTopName.isDisplayed());
        Assert.assertTrue(automationSearchProductPage.category.getText().contains("Women"));
        Assert.assertEquals(automationSearchProductPage.brand_polo.getText(), "Brand: Polo");
    }
}
