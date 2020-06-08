package employee;

import base.BaseTest;
import helpers.JsonTestDataHelper;
import model.Login;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;
import java.io.FileNotFoundException;

public class EmployeeTests extends BaseTest {

    private EmployeePage employeePage;

    @BeforeMethod
    public void setUpEmployeeTests() throws FileNotFoundException {
        LoginPage loginPage = new LoginPage(webDriver);
        Login login = (Login) JsonTestDataHelper.getLoginTestData("loginData")[0];
        employeePage = loginPage.loginAs(login);
    }

    @Test
    public void testAddEmployee(){
        employeePage.addEmployee("Juan","Juan@gmail.com","125463","5222", "MTZ",
                "Cuba","11600");
        Assert.assertTrue(employeePage.isSuccessAlertVisible());
    }

    @Test
    public void testAddEmployeeInvalidData(){
        employeePage.addEmployee("","Juan@gmail.com","125463","5222", "MTZ",
                "Cuba","11600");
        Assert.assertTrue(employeePage.isErrorAlertVisible());
    }
}
