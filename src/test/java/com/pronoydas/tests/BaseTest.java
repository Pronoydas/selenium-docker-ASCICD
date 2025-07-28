package com.pronoydas.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v135.filesystem.model.BucketFileSystemLocator;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.pronoydas.utility.PropertyLoader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver ;
	
	@BeforeSuite
	public void loadConfig() {
		PropertyLoader.initialize();
	}
	
	
	
	@BeforeMethod
	public void Steup(ITestContext context) throws Exception {
		
		                                               
		String boolVal=PropertyLoader.getPropertyValue("selenium.grid.enabled");
		if(Boolean.parseBoolean(boolVal)) {
			driver = getRemoteBrowser();
		}else {
			driver = getLocalBrowser();
		}
		driver.manage().window().maximize();
		context.setAttribute("DRIVER", this.driver);
		if(context.getName().equals("FlightReservation_E2E")) {
			String appUrl=PropertyLoader.getPropertyValue("flightReservationUrl");
		  driver.get(appUrl);
			
		}else {
			String appUrl=PropertyLoader.getPropertyValue("vendorapplicationUrl");
			driver.get(appUrl);
			
		}
		
	}
	private WebDriver getRemoteBrowser() throws Exception {
		Capabilities cap ;
		String browser=PropertyLoader.getPropertyValue("browserName");
		if(browser.equalsIgnoreCase(browser)) {
			cap = new ChromeOptions();
		}
		else {
			cap = new FirefoxOptions();
		}
		return new RemoteWebDriver(new URL(PropertyLoader.getPropertyValue("selenium.grid.urlFormat")) , cap);
	}
	
	private WebDriver getLocalBrowser() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
