package com.e2e.tests;

import com.e2e.pageObjects.LandingPage;
import com.e2e.resources.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Validate_navigation_bar_Test extends Base
{
    public static Logger log = (Logger) LogManager.getLogger(Base.class.getName());
    @BeforeTest
    public void startup() throws IOException
    {
        driver = inititalizeDriver();

    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void testNavigationBar()
    {
        driver.get(prop.getProperty("prod"));
        LandingPage lp = new LandingPage(driver);
        Assert.assertTrue(lp.getNavigation().isDisplayed());
        System.out.println(lp.getNavigation().isDisplayed());
    }
}
