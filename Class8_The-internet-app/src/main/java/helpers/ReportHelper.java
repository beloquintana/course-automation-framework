package helpers;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by abel.quintana on 30/03/2020.
 */
public class ReportHelper {
    public static final String REPORT_FOLDER_NAME = "Reports";
    public static String guid = UUID.randomUUID().toString();
    public static String fileName = "Report_" + guid + ".html";
    public static String reportName = "";
    private static ExtentReports extentReport;
    private static String filePath = "";

    private static final Logger logger = LogManager.getLogger(ReportHelper.class);


    private static ConcurrentHashMap extentTestMap = new ConcurrentHashMap();
    private static ReportHelper instance;

    private ReportHelper() throws Exception {
        createExtentReportInstance();
    }

    public static ReportHelper getInstance(){
        if (instance == null){
            //synchronized block to remove overhead
            synchronized (ReportHelper.class){
                if (instance == null){
                    try {
                        // if instance is null, initialize
                        instance = new ReportHelper();
                        logger.info("ReportHelper created");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }

    public ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public ExtentTest startTest(String testName) {
        logger.info("Start Test " + testName);
        ExtentTest test = extentReport.createTest(testName);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

    public void flush() {
        extentReport.flush();
        logger.info("ExtentReports flush");
    }

    private void createExtentReportInstance() throws Exception {

        if (filePath.equals("")) {
            throw new Exception("You need to call Init method to create an ExtentReports Object");
        }

        createReportPath();
        extentReport = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath + "\\" + REPORT_FOLDER_NAME + "\\" + fileName);
        htmlReporter.config().setDocumentTitle("Automation Report " + reportName);
        htmlReporter.config().setReportName(reportName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setEncoding("utf-8");

        extentReport.attachReporter(htmlReporter);
    }

    private static void createReportPath() {
        Path reportFolderPath = Paths.get(filePath, REPORT_FOLDER_NAME);
        new File(reportFolderPath.toString()).mkdirs();
    }

    public static void init(String reportPath, String reportName) throws Exception {
        if (extentReport == null) {
            filePath = reportPath;
            ReportHelper.reportName = reportName;
        } else {
            throw new Exception("ExtentReports is already initialized");
        }
    }
}

