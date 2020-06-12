package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By multipleWindowsLink = By.linkText("Multiple Windows");

    public HomePage(WebDriver webDriver){
        super(webDriver);
    }

    public MultipleWindowsPage clickOnMultipleWindowsLink(){
        webDriver.findElement(multipleWindowsLink).click();
        return new MultipleWindowsPage(webDriver);
    }
}
