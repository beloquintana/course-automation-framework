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
        //String user = csvHelper.getTestData("Login","user");
        //String pass = csvHelper.getTestData("Login","pass");
        //String user = xmlHelper.getTestData("Login","user");
        //String pass = xmlHelper.getTestData("Login","pass");
        String user = jsonHelper.getTestData("Login","user");
        String pass = jsonHelper.getTestData("Login","pass");
        EmployeePage employeePage = loginPage.loginAs(user,pass);
        Assert.assertTrue(employeePage.isEmployeePageDisplayed());
        Assert.assertEquals(employeePage.getUserNameText(), user);
    }

    @Test
    public void testInvalidCredentials(){
        LoginPage loginPage = new LoginPage(webDriver);
        //String user = csvHelper.getTestData("LoginInvalidCredentials","user");
        //String pass = csvHelper.getTestData("LoginInvalidCredentials","pass");
        //String user = xmlHelper.getTestData("LoginInvalidCredentials","user");
        //String pass = xmlHelper.getTestData("LoginInvalidCredentials","pass");
        String user = jsonHelper.getTestData("LoginInvalidCredentials","user");
        String pass = jsonHelper.getTestData("LoginInvalidCredentials","pass");

        loginPage.loginAs(user,pass);
        Assert.assertTrue(loginPage.isErrorMessageVisible());
    }

    @Test
    public void testLogOut(){
        LoginPage loginPage = new LoginPage(webDriver);
        //String user = csvHelper.getTestData("Login","user");
        //String pass = csvHelper.getTestData("Login","pass");
        //String user = xmlHelper.getTestData("Login","user");
        //String pass = xmlHelper.getTestData("Login","pass");
        String user = jsonHelper.getTestData("Login","user");
        String pass = jsonHelper.getTestData("Login","pass");
        EmployeePage employeePage = loginPage.loginAs(user,pass);
        loginPage = employeePage.clickOnLogOutButton();

        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }
}
