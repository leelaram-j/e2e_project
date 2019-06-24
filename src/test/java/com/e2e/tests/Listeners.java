package com.e2e.tests;

import com.e2e.resources.Base;
import com.e2e.resources.RetryAnalyser;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listeners implements ITestListener,ISuiteListener,IInvokedMethodListener,IAnnotationTransformer
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

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void onStart(ISuite suite) {

    }

    @Override
    public void onFinish(ISuite suite) {

    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
    {
        annotation.setRetryAnalyzer(RetryAnalyser.class);

    }
}
