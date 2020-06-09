package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage extends BasePage {
    private By nameInput = By.id("name");
    private By emailInput = By.id("email");
    private By cityInput = By.xpath("//*[@ng-model=\"city\"]");
    private By stateInput = By.id("state");
    private By postcodeInput = By.id("postcode");
    private By addressInput = By.id("address");
    private By phoneInput = By.id("phoneNumber");
    private By addButtonButton = By.id("addButton");
    private By formEmployee = By.id("gridEmployee");
    private By successAlert = By.id("success-alert");
    private By errorAlert = By.id("danger-alert");
    private By logOutButton = By.xpath("//*[@id=\"contentEmployee\"]/h4/span");

    public EmployeePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addEmployee(String name, String email, String address, String phone, String city, String state,
                            String postcode){
        webDriver.findElement(nameInput).sendKeys(name);
        webDriver.findElement(cityInput).sendKeys(city);
        webDriver.findElement(stateInput).sendKeys(state);
        webDriver.findElement(postcodeInput).sendKeys(postcode);
        webDriver.findElement(emailInput).sendKeys(email);
        webDriver.findElement(addressInput).sendKeys(address);
        webDriver.findElement(phoneInput).sendKeys(phone);
        webDriver.findElement(addButtonButton).click();
    }

    public boolean isEmployeePageDisplayed(){
        WebElement element = webDriver.findElement(formEmployee);
        return element.isDisplayed();
    }

    public boolean isSuccessAlertVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 3);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(successAlert)));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isErrorAlertVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 3);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(errorAlert)));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public LoginPage clickOnLogOutButton(){
        webDriver.findElement(logOutButton).click();
        return new LoginPage(webDriver);
    }

    public String getUserNameText(){
        return webDriver.findElement(logOutButton).getText();
    }
}
