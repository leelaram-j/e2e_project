package com.e2e.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage
{
    WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(@href,'sign_in')]")
    WebElement signIn;

    @FindBy(css=".text-center>h2")
    WebElement title;

    @FindBy(xpath = "//div[@role='navigation']")
    WebElement navigation;

    public WebElement getSignIn()
    {
        return signIn;
    }

    public WebElement getTitle()
    {
        return title;
    }

    public WebElement getNavigation()
    {
        return navigation;
    }
}
