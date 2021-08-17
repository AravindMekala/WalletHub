package com.facebook.selenium.commons;




import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.facebook.selenium.commons.ApplicationConfiguration;
import com.facebook.selenium.pageobjects.LoginPage;

public class ParameterizedTest {
    protected static WebDriver driver;
    protected static String userName;
    protected static String password;
    private static Logger log = LoggerFactory.getLogger(ParameterizedTest.class.getName());
    public static ExtentReports extent;
    
    //This method is for browser creation and login details.
    @BeforeClass
    public static void createDriverandLogin() {
    	
    	 userName = ApplicationConfiguration.get("fb.loginName");
         password = new String(Base64.getDecoder().decode(ApplicationConfiguration.get("fb.loginPassword")));
       driver=  WebDriverBuilder.newChromeDriver();
       log.info("===Launching browser===");
         driver.get(ApplicationConfiguration.get("fb.url"));
         LoginPage loginPage = new LoginPage(driver);
         loginPage.enterEmail(userName);
         loginPage.enterPassword(password);
         loginPage.submit();
         log.info("===Logged into Facebook===");  
        
    }
    
    
    @AfterClass
    public static void tearDown() {
        driver.quit();
        
    }
    
    public static ExtentReports extentReport() {
    	String path =System.getProperty("user.dir")+"\\report\\index.html";
    	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
    	reporter.config().setReportName("Facebook Automation Results");
    	reporter.config().setDocumentTitle("Test Results1");
    	
    	 extent =new ExtentReports();
    	extent.attachReporter(reporter);
    	return extent;
    
    }

    }

