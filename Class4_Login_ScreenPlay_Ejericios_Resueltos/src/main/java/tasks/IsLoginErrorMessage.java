package tasks;

import actions.WaitUntilElement;
import org.openqa.selenium.WebDriver;
import ui.LoginUI;

public class IsLoginErrorMessage {
    public static boolean visible(WebDriver webDriver){
        return WaitUntilElement.isVisible(webDriver, LoginUI.errorMessage);
    }
}
