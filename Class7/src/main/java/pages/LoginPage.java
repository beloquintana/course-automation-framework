package pages;

import model.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private By userInput = By.id("user");
    private By passWordInput = By.id("pass");
    private By loginButton = By.id("loginButton");
    private By errorMessage = By.name("errorMessage");

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public void typeUserName(String user){
        WebElement element = webDriver.findElement(userInput);
        element.sendKeys(user);
    }

    public void typePassWord(String passWord){
        WebElement element = webDriver.findElement(passWordInput);
        element.sendKeys(passWord);
    }

    public EmployeePage clickOnLoginButton(){
        WebElement element = webDriver.findElement(loginButton);
        element.click();
        return new EmployeePage(webDriver);
    }

    public EmployeePage loginAs(Login login){
        typeUserName(login.getUser());
        typePassWord(login.getPass());
        return clickOnLoginButton();
    }

    public boolean isErrorMessageVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 3);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(errorMessage)));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isLoginPageDisplayed(){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
            return webDriver.findElement(loginButton).isDisplayed();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
