package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends BasePage {

    private By clickHereLink = By.linkText("Click Here");

    public MultipleWindowsPage(WebDriver webDriver){
        super(webDriver);
    }

    public NewWindowPage clickOnClickHereLink(){
        webDriver.findElement(clickHereLink).click();
        return new NewWindowPage(webDriver);
    }
}
