package tasks;

import actions.Click;
import actions.Enter;
import org.openqa.selenium.WebDriver;
import ui.EmployeeUI;

public class AddEmployee {
    public static void withTheData(WebDriver webDriver, String name, String email, String address, String phone,
                                   String city, String state, String postalCode){
        Enter.text(webDriver, EmployeeUI.nameInput, name);
        Enter.text(webDriver, EmployeeUI.emailInput, email);
        Enter.text(webDriver, EmployeeUI.addressInput, address);
        Enter.text(webDriver, EmployeeUI.phoneInput, phone);
        Enter.text(webDriver, EmployeeUI.city, city);
        Enter.text(webDriver, EmployeeUI.state, state);
        Enter.text(webDriver, EmployeeUI.postCode, postalCode);
        Click.on(webDriver, EmployeeUI.addButton);
    }
}
