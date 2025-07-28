package com.pronoydas.pages.FilghtBooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.pronoydas.pages.BasePage;

public class FlightSearchPage extends BasePage {
	
	@FindBy(id = "passengers")
	private WebElement passengerCount;
	
	
	@FindBy(id = "search-flights") 
	private WebElement searchFlightBtn;
	
	
	
	public FlightSearchPage(WebDriver driver) {
        super(driver);
		AjaxElementLocatorFactory aelf = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(aelf, this);
		
	}
	
	
	public FlightSearchPage selectNumberPassenger(int count) {
		Select select = new Select(passengerCount);
		
		switch (count) {
		case 1: 
			select.selectByVisibleText("One");
			return this;
		case 2:
			select.selectByVisibleText("Two");
			return this;
		case 3: 
			select.selectByVisibleText("Three");
			return this;
		case 4:
			select.selectByVisibleText("Four");
			return this;
		default:
			return this;
		}
	}
	

	public SelectFlightsPage clickSearchFlightsBtn(WebDriver driver) {
		searchFlightBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SelectFlightsPage(driver);
	}

}
