package com.pronoydas.pages.FilghtBooking;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.pronoydas.pages.BasePage;

public class SelectFlightsPage extends BasePage{
	
	
	@FindBys({@FindBy(name = "departure-flight")})
	private List<WebElement> departureFlightList;
	
	@FindBys({@FindBy(name = "arrival-flight")})
	private List<WebElement> arrivalFlightList;
	
	@FindBy(id = "confirm-flights")
	private WebElement confirmFlightBtn;

	public SelectFlightsPage(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory aelf = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(aelf, this);
	}
	
	public SelectFlightsPage selectFlightOptions() {
		int random = new Random().nextInt(0, departureFlightList.size());
		departureFlightList.get(random).click();
		arrivalFlightList.get(random).click();
		return this;
		
	}
	
	
	public FlightConfirmationPage clickConfirmFlightBtn(WebDriver driver) {
		confirmFlightBtn.click();
		return new FlightConfirmationPage(driver);
	}


}
