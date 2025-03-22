package com.zerobank.hooks;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;

public class BankStart {
    public static WebDriver driver;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
//    @Before("@LoginFeature")
//    public void setup() {
//        driver = DriverManager.getFirefoxDriver();
//        driver.manage().window().maximize();
//        driver.get("http://zero.webappsecurity.com/");
//    }

    @BeforeAll
    public static void beforeAll() { 
        try {
            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/BankExtentReport.html");
            sparkReporter.config().setDocumentTitle("Zero Bank Report");
            sparkReporter.config().setReportName("Regression Testing");
            sparkReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester Name", "sathish");
            extent.setSystemInfo("Browser Name", "Chrome");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    @AfterAll
    public static void afterAll() {
        extent.flush();
    }
    @Before
    public void setup(Scenario scenario) {
        driver = DriverManager.getChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/");
        test=extent.createTest(scenario.getName());
    }
    @After()
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}
