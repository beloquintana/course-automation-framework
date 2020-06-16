package multipleWindows;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MultipleWindowsPage;
import pages.NewWindowPage;

public class MultipleWindowsTest extends BaseTest {

    @Test
    public void testMultipleWindow(){
        HomePage homePage = new HomePage(webDriver);
        MultipleWindowsPage multipleWindowsPage = homePage.clickOnMultipleWindowsLink();
        NewWindowPage newWindowPage = multipleWindowsPage.clickOnClickHereLink();

        Assert.assertEquals(newWindowPage.getHeaderPageText(),"New Window");
    }
}
