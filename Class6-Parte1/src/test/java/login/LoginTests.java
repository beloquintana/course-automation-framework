package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test(dataProvider="loginDataProvider")
    public void testSuccessfulLogin(String user, String pass){
        LoginPage loginPage = new LoginPage(webDriver);
        EmployeePage employeePage = loginPage.loginAs(user,pass);
        Assert.assertTrue(employeePage.isEmployeePageDisplayed());
        Assert.assertEquals(employeePage.getUserNameText(), user);
    }

    @Test(dataProvider = "loginInvalidDataProvider")
    public void testInvalidCredentials(String user, String pass){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginAs(user,pass);
        Assert.assertTrue(loginPage.isErrorMessageVisible());
    }

    @Test(dataProvider = "loginDataProvider")
    public void testLogOut(String user, String pass){
        LoginPage loginPage = new LoginPage(webDriver);
        EmployeePage employeePage = loginPage.loginAs(user,pass);
        loginPage = employeePage.clickOnLogOutButton();

        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @DataProvider(name="loginDataProvider")
    public Object[][] loginDataProvider(){
        return new Object[][] {
                        { "admin", "admin123" },
                };
    }

    @DataProvider(name="loginInvalidDataProvider")
    public Object[][] loginInvalidDataProvider(){
        return new Object[][] {
                { "admin", "admin" },
                { "", "admin" },
                { "", "" },
                { "admin", "" },
        };
    }
}
