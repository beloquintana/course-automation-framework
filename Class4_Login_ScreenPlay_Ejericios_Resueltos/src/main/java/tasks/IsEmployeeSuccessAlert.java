package tasks;

import actions.WaitUntilElement;
import org.openqa.selenium.WebDriver;
import ui.EmployeeUI;

public class IsEmployeeSuccessAlert {
    public static boolean visible(WebDriver webDriver){
        return WaitUntilElement.isVisible(webDriver, EmployeeUI.successAlert);
    }
}
