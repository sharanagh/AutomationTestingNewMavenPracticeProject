package com.selenium.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.util.ExtentReporter;

public class MyListeners implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	ExtentTest extentStep;
	WebDriver driver;

	
	
	
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Project Tests started executing");
		extentReport = ExtentReporter.generateExtentReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String testCasName = result.getName();
		// System.out.println(testCasName+ " - started executing");
		extentStep = extentReport.createTest(testCasName);
		extentStep.log(Status.INFO, testCasName + " - started executing");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String testCaseName = result.getName();
		// System.out.println(testCaseName +" - Successfully executed");
		extentStep.log(Status.PASS, testCaseName + " - Successfully executed");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		// System.out.println("All the test cases execution completed!!!");
		extentStep.log(Status.INFO, "All the test cases execution completed!!!");
		
		extentReport.flush();

	}
}
