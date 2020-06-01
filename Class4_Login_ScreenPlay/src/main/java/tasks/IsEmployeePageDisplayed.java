package tasks;

import actions.IsDisplayed;
import org.openqa.selenium.WebDriver;
import ui.EmployeeUI;

public class IsEmployeePageDisplayed {
    public static boolean form(WebDriver webDriver){
        return IsDisplayed.element(webDriver , EmployeeUI.form);
    }
}
