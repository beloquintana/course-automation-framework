package base;

import com.opencsv.exceptions.CsvException;
import helpers.CSVHelper;
import helpers.JsonHelper;
import helpers.XMLHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class BaseTest {
    protected WebDriver webDriver;
    private String url = "https://testfaceclub.com/login-employee-v2/";
    private String browser = "chrome";
    protected CSVHelper csvHelper;
    protected XMLHelper xmlHelper;
    protected JsonHelper jsonHelper;


    @BeforeClass
    public void suiteSetUp() throws IOException, CsvException, ParserConfigurationException, SAXException {
        csvHelper = new CSVHelper();
        csvHelper.readCSVFile("resource/files/example.csv");

        xmlHelper = new XMLHelper();
        xmlHelper.readXMLFile("resource/files/example.xml");

        jsonHelper = new JsonHelper();
        jsonHelper.readJsonFile("resource/files/example.json");
    }

    @BeforeMethod
    public void setUp() throws Exception {
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","resource/chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver","resource/geckodriver.exe");
                webDriver = new FirefoxDriver();
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
