package login;

import base.BaseTest;
import helpers.JsonTestDataHelper;
import model.Login;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;
import java.io.FileNotFoundException;

public class LoginTests extends BaseTest {

    @Test(dataProvider="loginDataProvider")
    public void testSuccessfulLogin(Login login){
        LoginPage loginPage = new LoginPage(webDriver);
        EmployeePage employeePage = loginPage.loginAs(login);
        Assert.assertTrue(employeePage.isEmployeePageDisplayed());
        Assert.assertEquals(employeePage.getUserNameText(), login.getUser());
    }

    @Test(dataProvider = "loginInvalidDataProvider")
    public void testInvalidCredentials(Login login){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginAs(login);
        Assert.assertTrue(loginPage.isErrorMessageVisible());
    }

    @Test(dataProvider = "loginDataProvider")
    public void testLogOut(Login login){
        LoginPage loginPage = new LoginPage(webDriver);
        EmployeePage employeePage = loginPage.loginAs(login);
        loginPage = employeePage.clickOnLogOutButton();

        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @DataProvider(name="loginDataProvider")
    public Object[] loginDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getLoginTestData("loginData");
    }

    @DataProvider(name="loginInvalidDataProvider")
    public Object[] loginInvalidDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getLoginTestData("loginInvalidData");
    }
}
