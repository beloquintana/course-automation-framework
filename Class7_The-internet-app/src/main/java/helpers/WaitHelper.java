package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    public static boolean WaitForPageTitle(WebDriver webDriver, String title, int timeOutInSeconds){
        try{
            WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
            wait.until(ExpectedConditions.titleIs(title));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean WaitForNumberOfWindows(WebDriver webDriver, int expectedNumberOfWindows, int timeOutInSeconds){
        try{
            WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
            wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
