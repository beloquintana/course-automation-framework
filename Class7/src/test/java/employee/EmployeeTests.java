package employee;

import base.BaseTest;
import helpers.JsonTestDataHelper;
import model.Employee;
import model.Login;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;
import java.io.FileNotFoundException;

public class EmployeeTests extends BaseTest {

    private EmployeePage employeePage;

    @BeforeMethod
    public void setUpEmployeeTests() throws FileNotFoundException {
        LoginPage loginPage = new LoginPage(webDriver);
        Login login = (Login) JsonTestDataHelper.getInstance().getLoginTestData("loginData")[0];
        employeePage = loginPage.loginAs(login);
    }

    @Test(dataProvider = "addEmployeeDataProvider")
    public void testAddEmployee(Employee employee){
        employeePage.addEmployee(employee);
        Assert.assertTrue(employeePage.isSuccessAlertVisible());
    }

    @Test(dataProvider = "addEmployeeInvalidDataProvider")
    public void testAddEmployeeInvalidData(Employee employee){
        employeePage.addEmployee(employee);
        Assert.assertTrue(employeePage.isErrorAlertVisible());
    }

    @DataProvider(name="addEmployeeDataProvider")
    public Object[] addEmployeeDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().getEmployeeTestData("employeeData");
    }

    @DataProvider(name="addEmployeeInvalidDataProvider")
    public Object[] addEmployeeInvalidDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().getEmployeeTestData("employeeInvalidData");
    }
}