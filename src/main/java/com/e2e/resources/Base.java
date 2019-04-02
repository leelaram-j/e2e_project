package com.e2e.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base
{
    public WebDriver driver = null;
    public Properties prop;
    FileInputStream fis;
    public static Logger log = (Logger) LogManager.getLogger(Base.class.getName());
    public WebDriver inititalizeDriver() throws IOException
    {
        prop = new Properties();
        fis = new FileInputStream("/Users/lee/Documents/E2E_Project/src/main/java/com/e2e/resources/data.properties");
        prop.load(fis);
        String browserType= prop.getProperty("browser");
        if(browserType.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriver"));
            driver = new ChromeDriver();
        }
        else if(browserType.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.firefox.driver",prop.getProperty("firefoxDriver"));
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("timeOut")),TimeUnit.SECONDS);
        return driver;
    }
}
