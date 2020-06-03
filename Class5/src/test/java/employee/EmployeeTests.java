package employee;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;

public class EmployeeTests extends BaseTest {

    private EmployeePage employeePage;

    @BeforeMethod
    public void setUpEmployeeTests(){
        LoginPage loginPage = new LoginPage(webDriver);
        employeePage = loginPage.loginAs("admin","admin123");
    }

    @Test
    public void testAddEmployee(){
        employeePage.addEmployee("Juan","Juan@gmail.com","125463","5222", "MTZ",
                "Cuba","11600");
        Assert.assertTrue(employeePage.isSuccessAlertVisible());
    }

    @Test
    public void testAddEmployeeEmptyFields(){
        employeePage.addEmployee("","","","", "",
                "","");
        Assert.assertTrue(employeePage.isErrorAlertVisible());
    }
}
