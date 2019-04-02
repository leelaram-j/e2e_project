package com.e2e.tests;

import com.e2e.pageObjects.LandingPage;
import com.e2e.resources.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Validate_title_Test extends Base
{
    public static Logger log = (Logger) LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void startup() throws IOException
    {
        driver = inititalizeDriver();
        log.info("Driver is initiated");

    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void testTitleName()
    {
        driver.get(prop.getProperty("prod"));
        LandingPage lp = new LandingPage(driver);
        String titleName = lp.getTitle().getText();
        Assert.assertEquals(lp.getTitle().getText(),"FEATURED COURSES");
        System.out.println(titleName);

    }
}
