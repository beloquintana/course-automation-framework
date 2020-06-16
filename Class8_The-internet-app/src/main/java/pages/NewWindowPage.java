package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewWindowPage extends BasePage {

    private By headerPage = By.xpath("/html//h3");

    public NewWindowPage(WebDriver webDriver){
        super(webDriver);

        String mainWindow = getCurrentWindow();
        String secondWindow = getSecondWindow(mainWindow);
        webDriver.switchTo().window(secondWindow);

        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.titleIs("New Window"));
    }

    public String getHeaderPageText(){
        return webDriver.findElement(headerPage).getText();
    }

}
