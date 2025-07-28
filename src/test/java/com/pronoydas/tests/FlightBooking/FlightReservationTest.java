package com.pronoydas.tests.FlightBooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pronoydas.pages.FilghtBooking.FlightConfirmationPage;
import com.pronoydas.pages.FilghtBooking.RegistrationConfirmationPage;
import com.pronoydas.pages.FilghtBooking.RegistrationPage;
import com.pronoydas.tests.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightReservationTest extends BaseTest{
	
	//https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html
	
	
	
	
	@Test(description = "Register User",priority = 0)
	public void userRegister() {
		RegistrationConfirmationPage rcp=new RegistrationPage(driver)
		.enterFullName().enterEmail().enterPassword()
		.selectState().clickOnRegisterBtn(driver);
		String str = rcp.getHeadingText();
		Assert.assertEquals(str, "Registration Confirmation", "Heading is not Matching !!");
	}
	
	@Test(description = "Search Flights",priority = 1)
	public void SearchForFlight() {
		RegistrationConfirmationPage rcp=new RegistrationPage(driver)
		.enterFullName().enterEmail().enterPassword()
		.selectState().clickOnRegisterBtn(driver);
		rcp.clickSearchFlight(driver)
		.selectNumberPassenger(3).clickSearchFlightsBtn(driver);
	}
	
	
	@Test(description = "Booking Flights",priority = 1)
	public void bookFlight() {
		RegistrationConfirmationPage rcp=new RegistrationPage(driver)
		.enterFullName().enterEmail().enterPassword()
		.selectState().clickOnRegisterBtn(driver);
		
		FlightConfirmationPage fcp=rcp.clickSearchFlight(driver)
		.selectNumberPassenger(3).clickSearchFlightsBtn(driver)
		.selectFlightOptions().clickConfirmFlightBtn(driver);
	
		System.out.println(fcp.getConformationTag());
		System.out.println(fcp.getPrice());
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
