package pages;

import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewWindowPage extends BasePage {

    private By headerPage = By.xpath("/html//h3");

    public NewWindowPage(WebDriver webDriver) throws Exception {
        super(webDriver);

        waitForPageOpen();
        String mainWindow = getCurrentWindow();
        String secondWindow = getNewWindow(mainWindow);
        webDriver.switchTo().window(secondWindow);
        waitForPageTitle();
    }

    public String getHeaderPageText(){
        return webDriver.findElement(headerPage).getText();
    }

    private void waitForPageOpen() throws Exception {
        int timeOut = 3;
        if(!WaitHelper.WaitForNumberOfWindows(webDriver,2, timeOut))
            throw new Exception("NewWindowPage not found after " + timeOut + " seconds");
    }

    private void waitForPageTitle() throws Exception {
        int timeOut = 3;
        if(!WaitHelper.WaitForPageTitle(webDriver,"New Window", timeOut))
            throw new Exception("NewWindowPage not found after " + timeOut + " seconds");
    }

}
