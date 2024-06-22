package com.selenium.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Base {
	Properties prop;
	WebDriver driver;
	
	public Properties readPropdt() throws IOException {
	String path = "D:\\Practice2\\TestNG_Practice\\src\\com\\propertyFile\\config.properties";
	FileInputStream fis = new FileInputStream(path);
	Properties prop = new Properties();
	prop.load(fis);
	System.out.println(prop.getProperty("url"));
	System.out.println(prop.getProperty("browserName"));
	return prop;
	}
	
	public WebDriver browserIntializatio(String broserName, String url) {
		if(broserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(broserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("No Browser Found!!");
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
}