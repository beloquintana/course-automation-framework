package addproducts;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProductPage;
import pages.ProductsPage;

public class AddProductTests extends BaseTest {

    @Test
    public void testAddProduct(){
        ProductsPage productsPage = new ProductsPage(webDriver);
        AddProductPage addProductPage = productsPage.clickOnAddButton();

        int expectedProductName = productsPage.getTableRowsCount() + 1;
        addProductPage.addProduct("laptop", "580", "Product-45L");

        int actualProductName = productsPage.getTableRowsCount();

        Assert.assertEquals(expectedProductName, actualProductName);
    }

}
