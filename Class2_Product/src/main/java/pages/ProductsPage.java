package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {

    private By productNameInput = By.id("inputName");
    private By productPriceInput = By.xpath("//*[@ng-model='filterPrice']");
    private By productModelSelect = By.xpath("//*[@ng-model='filterModel']");
    private By filterButton = By.id("filterButton");
    private By addButton = By.id("add");

    public ProductsPage(WebDriver webDriver){
        super(webDriver);
    }

    public void typeProductName(String name){
        webDriver.findElement(productNameInput).sendKeys(name);
    }

    public void typeProductPrice(String price){
        webDriver.findElement(productPriceInput).sendKeys(price);
    }

    public void selectProductModel(String model){
        Select select = new Select(webDriver.findElement(productModelSelect));
        select.selectByVisibleText(model);
    }

    public void clickOnFilterButton(){
        webDriver.findElement(filterButton).click();
    }

    public AddProductPage clickOnAddButton(){
        webDriver.findElement(addButton).click();
        return new AddProductPage(webDriver);
    }

    public String getTableItem(int row, int column){
        return webDriver.findElement(By.xpath("//*[@id=\"filterTable\"]/tbody/tr["+ row +"]/td["+ column +"]")).getText();
    }

    public int getTableRowsCount(){
        return webDriver.findElements(By.xpath("//*[@id='filterTable']/tbody/tr")).size();
    }
}
