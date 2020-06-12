package pages;

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

    protected String getNewWindow(String mainWindow){
        Set<String> allWindows = webDriver.getWindowHandles();
        for (String window : allWindows) {
            if(!window.equals(mainWindow))
                return window;
        }

        return "";
    }
}
