package com.pronoydas.tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v135.filesystem.model.BucketFileSystemLocator;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.LoggerFactory;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.pronoydas.utility.Constants;
import com.pronoydas.utility.PropertyLoader;

import ch.qos.logback.classic.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver ;
	private static final Logger log = (Logger) LoggerFactory.getLogger(BaseTest.class);
	
	@BeforeSuite
	public void loadConfig() {
		log.info("Executing LoadConfig");
		PropertyLoader.initialize();
		log.info("Comptete Executing LoadConfig");
	}
	
	
	
	@BeforeMethod
	public void Steup(ITestContext context) throws Exception {
		
		log.info("Start Setup!!");                                               
		String boolVal=PropertyLoader.getPropertyValue("selenium.grid.enabled");
		if(Boolean.parseBoolean(boolVal)) {
			log.info("Getting Remote Browser Info"); 
			driver = getRemoteBrowser();
			log.info("Init WebDriver"); 
		}else {
			driver = getLocalBrowser();
		}
		driver.manage().window().maximize();
		context.setAttribute("DRIVER", this.driver);
		log.info("Looking for Test Suite");
		if(context.getName().equals("FlightReservation_E2E")) {
			String appUrl=PropertyLoader.getPropertyValue("flightReservationUrl");
		  driver.get(appUrl);
		  log.info("Start Executing flightReservation Tests");
			
		}else {
			String appUrl=PropertyLoader.getPropertyValue("vendorapplicationUrl");
			driver.get(appUrl);
			log.info("Start Executing vendorapplication Tests");
			
		}
		
	}
	private WebDriver getRemoteBrowser() throws Exception {
		String urlFormat = PropertyLoader.getPropertyValue(Constants.GRID_URL_FORMAT);
        String hubHost = PropertyLoader.getPropertyValue(Constants.GRID_HUB_HOST);
        String url = String.format(urlFormat, hubHost);
        log.info("grid url: {}", url);
		Capabilities cap ;

		String browser=PropertyLoader.getPropertyValue("browserName");
		log.info("Reading Browser Name "+browser);
		if(browser.equalsIgnoreCase(browser)) {
			cap = new ChromeOptions();
		}
		else {
			cap = new FirefoxOptions();
		}
		log.info("Start Creating  Object Of Remote Web Driver!! ");
		RemoteWebDriver driver= new RemoteWebDriver(new URI(url).toURL() , cap);
		log.info("Created Object Of Remote Web Driver!! ");
		return driver;
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
