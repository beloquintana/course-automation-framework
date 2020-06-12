package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.URL;

public class BaseTest {
    protected WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"url","browser","seleniumGridUrl"})
    public void setUp(String url, String browser, String seleniumGridUrl) throws Exception {
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","resource/chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case "chrome-remote":
                webDriver = new RemoteWebDriver(new URL(seleniumGridUrl),new ChromeOptions());
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver","resource/geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            case "firefox-remote":
                webDriver = new RemoteWebDriver(new URL(seleniumGridUrl),new FirefoxOptions());
                break;
            default:
                throw new Exception(browser + " no soportado");
        }
        webDriver.get(url);
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        if(webDriver != null)
            webDriver.quit();
    }
}
