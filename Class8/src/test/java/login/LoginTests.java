package login;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import helpers.JsonTestDataHelper;
import helpers.ReportHelper;
import model.Login;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;
import java.io.FileNotFoundException;

public class LoginTests extends BaseTest {
    public static String loginTestDataPath = "resource/testdata/login/";

    @Test(dataProvider="loginDataProvider")
    public void testSuccessfulLogin(Login login){
        ReportHelper.getInstance().getTest().log(Status.INFO,"Test data: " + login.toString());
        LoginPage loginPage = new LoginPage(webDriver);
        EmployeePage employeePage = loginPage.loginAs(login);
        Assert.assertTrue(employeePage.isEmployeePageDisplayed());
        Assert.assertEquals(employeePage.getUserNameText(), login.getUser());
    }

    @Test(dataProvider = "loginInvalidDataProvider")
    public void testInvalidCredentials(Login login){
        ReportHelper.getInstance().getTest().log(Status.INFO,"Test data: " + login.toString());
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginAs(login);
        Assert.assertTrue(loginPage.isErrorMessageVisible());
    }

    @Test(dataProvider = "loginDataProvider")
    public void testLogOut(Login login){
        ReportHelper.getInstance().getTest().log(Status.INFO,"Test data: " + login.toString());
        LoginPage loginPage = new LoginPage(webDriver);
        EmployeePage employeePage = loginPage.loginAs(login);
        loginPage = employeePage.clickOnLogOutButton();

        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @DataProvider(name="loginDataProvider")
    public Object[] loginDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().geTestData(loginTestDataPath + "loginData.json", Login.class);
    }

    @DataProvider(name="loginInvalidDataProvider")
    public Object[] loginInvalidDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().geTestData(loginTestDataPath + "loginInvalidData.json", Login.class);
    }
}
