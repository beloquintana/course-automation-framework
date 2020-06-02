package ui;

import org.openqa.selenium.By;

public class EmployeeUI {
    public static By form = By.id("contentEmployee");
    public static By nameInput = By.id("name");
    public static By emailInput = By.id("email");
    public static By addressInput = By.id("address");
    public static By phoneInput = By.id("phoneNumber");
    public static By city = By.xpath("//*[@id='gridEmployee']/tbody/tr/td/form/fieldset/div[3]/div/div/input");
    public static By state = By.id("state");
    public static By postCode = By.id("postcode");
    public static By successAlert = By.id("success-alert");
    public static By addButton = By.id("addButton");
}
