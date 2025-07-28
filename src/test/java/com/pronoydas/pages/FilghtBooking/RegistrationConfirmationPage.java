package com.pronoydas.pages.FilghtBooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.pronoydas.pages.BasePage;

public class RegistrationConfirmationPage extends BasePage{
	
	
	
	@FindBy(id = "go-to-flights-search")
	private WebElement searchFlightBtn ;
	
	@FindBy(xpath = "//*[text()='Registration Confirmation']") 
	private WebElement conformationHeading;
	
	
	
	
	public RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
		AjaxElementLocatorFactory aelf = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(aelf, this);
	}
	
	
	public String getHeadingText() {
		return conformationHeading.getText();
	}
	 //FlightSearchPage
	public FlightSearchPage clickSearchFlight(WebDriver driver) {
		searchFlightBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new FlightSearchPage(driver); 
	}

}
