package com.e2e.resources;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Base
{
    public static WebDriver driver = null;
    public Properties prop;
    FileInputStream fis;
    //even this path can be configured in the properties file and called here
    public static String path = "//Users//lee//Pictures//screenshots//";
    public static String extension =".png";
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static LocalDateTime now = LocalDateTime.now();

//    public static Logger log = (Logger) LogManager.getLogger(Base.class.getName());
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
    public static void getScreenshot(String testName) throws IOException
    {
        File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String finalPath=path+testName+"_"+dtf.format(now)+extension;
        FileUtils.copyFile(src,new File(finalPath));
    }
}
