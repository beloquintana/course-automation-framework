package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    public static boolean waitForVisibilityOf(WebDriver webDriver, By locator, int timeOutInSeconds){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(locator)));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
