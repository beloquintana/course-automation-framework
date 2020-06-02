package employee;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.AddEmployee;
import tasks.IsEmployeeSuccessAlert;
import tasks.Login;

public class EmployeeTests extends BaseTest {

    @Test
    public void testAddEmployee(){
        Login.as(webDriver,"admin","admin123");
        AddEmployee.withTheData(webDriver, "Juan", "juan@gmail.com","MTZ","555855",
                "MTZ", "Cuba","11500");
        Assert.assertTrue(IsEmployeeSuccessAlert.visible(webDriver));
    }
}
