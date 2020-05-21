package filters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class FilterTests extends BaseTest {

    @Test
    public void testFilterByName(){
        ProductsPage productsPage = new ProductsPage(webDriver);
        String expectedProductName = "Apple Cinema 30";
        productsPage.typeProductName(expectedProductName);
        productsPage.clickOnFilterButton();

        String actualProductName = productsPage.getTableItem(1,1);
        Assert.assertEquals(actualProductName, expectedProductName);
    }

    @Test
    public void testFilterByModel(){
        ProductsPage productsPage = new ProductsPage(webDriver);
        String expectedProductModel = "SAM";
        productsPage.selectProductModel(expectedProductModel);
        productsPage.clickOnFilterButton();

        String actualProductModel = productsPage.getTableItem(1,2);
        Assert.assertEquals(actualProductModel, expectedProductModel);
    }

    @Test
    public void testFilterByPrice(){
        ProductsPage productsPage = new ProductsPage(webDriver);
        String expectedProductPrice = "15";
        productsPage.typeProductPrice(expectedProductPrice);
        productsPage.clickOnFilterButton();

        String actualProductPrice = productsPage.getTableItem(1,3);
        Assert.assertEquals(actualProductPrice, expectedProductPrice);
    }

    @Test
    public void testFilterByPriceModelName(){
        ProductsPage productsPage = new ProductsPage(webDriver);
        String expectedProductName = "HTC Touch HD";
        String expectedProductModel = "Product-5g";
        String expectedProductPrice = "101";
        productsPage.typeProductPrice(expectedProductPrice);
        productsPage.typeProductName(expectedProductName);
        productsPage.selectProductModel(expectedProductModel);
        productsPage.clickOnFilterButton();

        String actualProductName = productsPage.getTableItem(1,1);
        String actualProductModel = productsPage.getTableItem(1,2);
        String actualProductPrice = productsPage.getTableItem(1,3);

        Assert.assertEquals(actualProductName, expectedProductName);
        Assert.assertEquals(actualProductModel, expectedProductModel);
        Assert.assertEquals(actualProductPrice, expectedProductPrice);
    }
}
