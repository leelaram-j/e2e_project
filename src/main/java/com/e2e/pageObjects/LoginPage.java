package com.e2e.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='user_email']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='user_password']")
    WebElement password;

    @FindBy(xpath = "//input[@name='commit']")
    WebElement submit;

    public WebElement getUserName()
    {
        return userName;
    }

    public WebElement getPassword()
    {
        return password;
    }

    public WebElement getSubmit()
    {
        return submit;
    }
}
