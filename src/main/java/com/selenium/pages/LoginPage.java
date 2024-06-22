package com.selenium.pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
WebDriver driver;

public LoginPage(WebDriver driver) {
	this.driver = driver;
}

public void enterUserNameAndPassword(String email, String password) {
	driver.findElement(By.id("input-email")).sendKeys(email);
	driver.findElement(By.id("input-password")).sendKeys(password);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
}


  public void verifyWarningMessage() { WebElement text= driver.findElement(By.
  xpath("//div[@class = 'alert alert-danger alert-dismissible']")); String
  actualText = text.getText(); 
  String expectedText = "Warning: No match for E-Mail Address and/or Password.";
  
  org.testng.Assert.assertTrue(actualText.contains(expectedText),
  "loginWithValidUsernameAndInvalidPassword test case failed"); 
  }
 

	/*
	 * public void verifyLoginSuccessfulNot() { WebElement elm =
	 * driver.findElement(By.linkText("Edit your account information"));
	 * if(elm.isDisplayed()) { System.out.println("Login successful "
	 * +elm.isDisplayed()); } else { System.out.println("Login Failed "
	 * +elm.isDisplayed()); }
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); String
	 * actualText =
	 * driver.findElement(By.linkText("Edit your account information")).getText();
	 * String expectedText = "Edit your account information";
	 * Assert.assertEquals(actualText, expectedText,
	 * "loginWithValidUserNamePassword test case failed");
	 * System.out.println("Actual Text:" + actualText);
	 * System.out.println("Expected Text:" + expectedText); }
	 */

}
