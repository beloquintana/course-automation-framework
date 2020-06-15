package employee;

import base.BaseTest;
import helpers.JsonTestDataHelper;
import login.LoginTests;
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
    public static String loginTestDataPath = "resource/testdata/employee/";
    private EmployeePage employeePage;

    @BeforeMethod
    public void setUpEmployeeTests() throws FileNotFoundException {
        LoginPage loginPage = new LoginPage(webDriver);
        Login login = (Login) JsonTestDataHelper.getInstance().
                geTestData(LoginTests.loginTestDataPath + "loginData.json", Login.class)[0];
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
        return JsonTestDataHelper.getInstance().geTestData(loginTestDataPath + "employeeData.json", Employee.class);
    }

    @DataProvider(name="addEmployeeInvalidDataProvider")
    public Object[] addEmployeeInvalidDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().geTestData(loginTestDataPath + "employeeInvalidData.json", Employee.class);
    }
}