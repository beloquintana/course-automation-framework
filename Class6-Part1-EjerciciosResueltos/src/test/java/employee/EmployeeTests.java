package employee;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "addEmployeeDataProvider")
    public void testAddEmployee(String name, String email, String address, String phone, String city,
                                String state, String postcode){
        employeePage.addEmployee(name,email,address,phone, city,state,postcode);
        Assert.assertTrue(employeePage.isSuccessAlertVisible());
    }

    @Test(dataProvider = "addEmployeeInvalidDataProvider")
    public void testAddEmployeeEmptyFields(String name, String email, String address, String phone, String city,
                                           String state, String postcode){
        employeePage.addEmployee(name,email,address,phone, city,state,postcode);
        Assert.assertTrue(employeePage.isErrorAlertVisible());
    }

    @DataProvider(name="addEmployeeDataProvider")
    public Object[][] addEmployeeDataProvider(){
        return new Object[][] {
                { "Juan","Juan@gmail.com","125463","5222","MTZ","Cuba","11600" },
                { "Juan Alberto","Juan@gmail.com","125463","5222","MTZ","Cuba","11600" },
        };
    }

    @DataProvider(name="addEmployeeInvalidDataProvider")
    public Object[][] addEmployeeInvalidDataProvider(){
        return new Object[][] {
                { "","","125463","5222","MTZ","Cuba","11600" },
                { "Juan","Juan.gmail.com","125463","5222","MTZ","Cuba","11600" },
        };
    }
}
