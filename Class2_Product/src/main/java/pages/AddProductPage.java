package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductPage extends BasePage {

    protected By productNameInput = By.id("inputName2");
    private By productPriceInput = By.name("inputPrice2");
    private By productModelDropDown = By.xpath("//*[@ng-model='addModel.value']/div[1]");
    private By addButton = By.xpath("//*[@id=\"myModal\"]//button[2]");
    private By modalForm = By.id("myModal");

    public AddProductPage(WebDriver webDriver){
        super(webDriver);

        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(modalForm)));
    }

    public void typeProductName(String name){
        webDriver.findElement(productNameInput).sendKeys(name);
    }

    public void typeProductPrice(String price){
        webDriver.findElement(productPriceInput).sendKeys(price);
    }

    public void selectProductModel(String model){
        webDriver.findElement(productModelDropDown).click();
        By optionToSelect = By.xpath("//*[@ng-model='addModel.value']//div[contains(text(),'"+ model +"')]");

        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(optionToSelect));

        webDriver.findElement(optionToSelect).click();
    }

    public void clickOnAddButton(){
        webDriver.findElement(addButton).click();
    }

    public void addProduct(String name, String price, String model){
        typeProductName(name);
        typeProductPrice(price);
        selectProductModel(model);
        clickOnAddButton();
    }

}
