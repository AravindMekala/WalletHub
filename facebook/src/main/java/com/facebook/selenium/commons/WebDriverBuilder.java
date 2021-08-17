package com.facebook.selenium.commons;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.facebook.selenium.commons.WebDriverBuilder;
import com.facebook.selenium.commons.ApplicationConfiguration;

public class WebDriverBuilder {
	 private static Logger log = LoggerFactory.getLogger(WebDriverBuilder.class.getName());
	 
	 public static WebDriver newChromeDriver() {

    	 RemoteWebDriver chromeDriver = null;

    	 ChromeOptions options = new ChromeOptions();
    	 options.addArguments("--disable-notifications");
    	 options.setAcceptInsecureCerts(true);
    	 options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
    	 
         try {
             System.setProperty("webdriver.chrome.driver", ApplicationConfiguration.get("webDriver.windows.chromeDriver"));
             chromeDriver=new ChromeDriver(options);
             chromeDriver.manage().window().setSize(new Dimension(ApplicationConfiguration.getInteger("browser.width"), ApplicationConfiguration.getInteger("browser.height")));
         
         }catch (Exception e) {
             log.error("Failed to init web driver", e);
         }
         return chromeDriver;  
}
}
