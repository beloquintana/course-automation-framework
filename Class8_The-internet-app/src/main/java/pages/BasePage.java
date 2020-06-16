package pages;

import helpers.JsonTestDataHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    protected String getCurrentWindow(){
        return webDriver.getWindowHandle();
    }

    protected String getSecondWindow(String mainWindow){

        Set<String> allWindows = webDriver.getWindowHandles();
        for (String window : allWindows) {
            if(!window.equals(mainWindow))
                return window;
        }

        return "";
    }
}
