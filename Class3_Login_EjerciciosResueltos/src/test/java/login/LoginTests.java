package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = new LoginPage(webDriver);
        EmployeePage employeePage = loginPage.loginAs("admin","admin123");
        Assert.assertTrue(employeePage.isEmployeePageDisplayed());
        Assert.assertEquals(employeePage.getUserNameText(), "admin");
    }

    @Test
    public void testInvalidCredentials(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginAs("admin","admin1253");
        Assert.assertTrue(loginPage.isErrorMessageVisible());
    }

    @Test
    public void testLogOut(){
        LoginPage loginPage = new LoginPage(webDriver);
        EmployeePage employeePage = loginPage.loginAs("admin","admin123");
        loginPage = employeePage.clickOnLogOutButton();

        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }
}
