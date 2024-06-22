package com.selenium.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
WebDriver driver;
Properties prop;

public HomePage(WebDriver driver) {
	this.driver = driver;
}

public void clickOnAccount() {
	driver.findElement(By.xpath("//span[text()= 'My Account']")).click();
	
	}


public void selectLoginOption() {
	driver.findElement(By.linkText("Login")).click();
}
}
