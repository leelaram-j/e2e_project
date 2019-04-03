package com.e2e.tests;

import com.e2e.resources.Base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener
{

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult)
    {
        System.out.println(iTestResult.getName()+" is executed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        try
        {
            Base.getScreenshot(result.getName());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult)
    {
        System.out.println(iTestResult.getName()+" is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
