package base;

import com.aventstack.extentreports.Status;
import helpers.ReportHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.URL;

public class BaseTest {
    protected WebDriver webDriver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() throws Exception {
        ReportHelper.init("resource", "Class8");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"url","browser","seleniumGridUrl"})
    public void setUp(String url, String browser, String seleniumGridUrl, Method method) throws Exception {
        ReportHelper.getInstance().startTest(method.getName());
        ReportHelper.getInstance().getTest().log(Status.INFO, "Browser: " + browser);
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","resource/chromedriver.exe");
                webDriver = new ChromeDriver();
                logger.info("Start ChromeDriver");
                break;
            case "chrome-remote":
                webDriver = new RemoteWebDriver(new URL(seleniumGridUrl),new ChromeOptions());
                logger.info("Start Remote ChromeDriver");
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver","resource/geckodriver.exe");
                webDriver = new FirefoxDriver();
                logger.info("Start FirefoxDriver");
                break;
            case "firefox-remote":
                webDriver = new RemoteWebDriver(new URL(seleniumGridUrl),new FirefoxOptions());
                logger.info("Start Remote FirefoxDriver");
                break;
            default:
                throw new Exception(browser + " no soportado");
        }
        webDriver.get(url);
        webDriver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
            ReportHelper.getInstance().getTest().log(Status.ERROR, "Message: "
                    + result.getThrowable().getMessage());

        if(webDriver != null){
            webDriver.quit();
            logger.info("webDriver quit");
        }

    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() throws Exception {
        ReportHelper.getInstance().flush();
    }

}
