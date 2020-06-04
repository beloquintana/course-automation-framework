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
        //String user = csvHelper.getTestData("Login","user");
        //String pass = csvHelper.getTestData("Login","pass");
        //String user = xmlHelper.getTestData("Login","user");
        //String pass = xmlHelper.getTestData("Login","pass");
        String user = jsonHelper.getTestData("Login","user");
        String pass = jsonHelper.getTestData("Login","pass");
        LoginPage loginPage = new LoginPage(webDriver);
        employeePage = loginPage.loginAs(user,pass);
    }

    @Test
    public void testAddEmployeeDataFromCSV(){
        String name = csvHelper.getTestData("Employee","name");
        String email = csvHelper.getTestData("Employee","email");
        String address = csvHelper.getTestData("Employee","address");
        String phone = csvHelper.getTestData("Employee","phone");
        String city = csvHelper.getTestData("Employee","city");
        String state = csvHelper.getTestData("Employee","state");
        String postCode = csvHelper.getTestData("Employee","postCode");
        employeePage.addEmployee(name,email,address,phone, city,
                state,postCode);
        Assert.assertTrue(employeePage.isSuccessAlertVisible());
    }

    @Test
    public void testAddEmployeeDataFromXML(){
        String name = xmlHelper.getTestData("Employee","name");
        String email = xmlHelper.getTestData("Employee","email");
        String address = xmlHelper.getTestData("Employee","address");
        String phone = xmlHelper.getTestData("Employee","phone");
        String city = xmlHelper.getTestData("Employee","city");
        String state = xmlHelper.getTestData("Employee","state");
        String postCode = xmlHelper.getTestData("Employee","postCode");
        employeePage.addEmployee(name,email,address,phone, city,
                state,postCode);
        Assert.assertTrue(employeePage.isSuccessAlertVisible());
    }

    @Test
    public void testAddEmployeeDataFromJson(){
        String name = jsonHelper.getTestData("Employee","name");
        String email = jsonHelper.getTestData("Employee","email");
        String address = jsonHelper.getTestData("Employee","address");
        String phone = jsonHelper.getTestData("Employee","phone");
        String city = jsonHelper.getTestData("Employee","city");
        String state = jsonHelper.getTestData("Employee","state");
        String postCode = jsonHelper.getTestData("Employee","postCode");
        employeePage.addEmployee(name,email,address,phone, city,
                state,postCode);
        Assert.assertTrue(employeePage.isSuccessAlertVisible());
    }

    @Test
    public void testAddEmployeeEmptyFields(){
        employeePage.addEmployee("","","","", "",
                "","");
        Assert.assertTrue(employeePage.isErrorAlertVisible());
    }
}
