package com.e2e.tests;


import com.e2e.pageObjects.LandingPage;
import com.e2e.pageObjects.LoginPage;
import com.e2e.resources.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.*;

import java.io.IOException;

public class Home_PageTest extends Base
{
    public static Logger log = (Logger) LogManager.getLogger(Base.class.getName());
    @BeforeTest
    public void startup() throws IOException
    {
        driver = inititalizeDriver();
        log.info("Driver is initiated");

    }
    @Test
    public void basePageNavigation()
    {
        driver.get(prop.getProperty("prod"));
        log.info("url is opened");
        LandingPage lp = new LandingPage(driver);
        lp.getSignIn().click();
        log.info("Clicked on Sign-In");
        LoginPage l = new LoginPage(driver);
        l.getUserName().sendKeys(prop.getProperty("userName"));
        log.info("sending user name");
        l.getPassword().sendKeys(prop.getProperty("password"));
        log.info("sending password");
        l.getSubmit().click();
        log.info("Clicking on submit");
    }
    @AfterTest
    public void tearDown()
    {
        driver.quit();
        log.info("Quitting driver");
    }
    @DataProvider
    public Object[][] getData()
    {
        Object [][] data = new Object[2][3];
        data[0][0] = "test@test.com";
        data[0][1] = "123456";
        data[0][2] = "Normal User";
        data[1][0] = "test1@test.com";
        data[1][1] = "1256789";
        data[1][2] = "Banned User";
        return data;
    }

    // Below test is executed using Data Provider annotation
    @Test(dataProvider = "getData")
    public void basePageNavigationDP(String userName,String password, String userType ) throws IOException
    {
        driver.get(prop.getProperty("prod"));
        log.info("url is opened");
        LandingPage lp = new LandingPage(driver);
        lp.getSignIn().click();
        log.info("Clicked on Sign-In");
        LoginPage l = new LoginPage(driver);
        l.getUserName().sendKeys(userName);
        log.info("sending user name");
        l.getPassword().sendKeys(password);
        log.info("sending password");
        l.getSubmit().click();
        log.info("Clicking on submit");
        //System.out.println((userType));
    }
}
