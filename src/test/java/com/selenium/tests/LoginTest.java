package com.selenium.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.base.Base;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;
import com.selenium.utilities.ReadDataFromExcel;

public class LoginTest extends Base {
	WebDriver driver;
	Properties prop;

	@BeforeMethod
	public void startWebBrowser() throws IOException {
		prop = readPropdt();
		driver = browserIntializatio(prop.getProperty("browserName"), prop.getProperty("url"));
		HomePage home = new HomePage(driver);
		home.clickOnAccount();
		home.selectLoginOption();
	}

	@DataProvider(name = "supplyTestData")
	public Object[][] loginData() throws Exception {
		Object[][] data = ReadDataFromExcel.readDataFromExcelFl("LoginData");
		return data;
	}

	@Test(dataProvider = "supplyTestData", priority = 1)

	public void loginWithValidCred(String email, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameAndPassword(email, password);
		/* loginpage.verifyLoginSuccessfulNot(); */
	}

	@Test(priority = 2)
	public void loginWithInvalidCred() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameAndPassword("Sharana", "Pass123");
		loginPage.verifyWarningMessage(); 
		/* loginPage.verifyLoginSuccessfulNot(); */
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
