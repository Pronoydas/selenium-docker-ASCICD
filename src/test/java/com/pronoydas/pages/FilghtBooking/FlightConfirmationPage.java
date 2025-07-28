package com.pronoydas.pages.FilghtBooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.pronoydas.pages.BasePage;

public class FlightConfirmationPage  extends BasePage{
	
	
	@FindBy(xpath ="//div[normalize-space()='Flight Confirmation #']//following-sibling::div//p")
	private WebElement conformationtag ;
	
	
	@FindBy(xpath = "//div[normalize-space()='Total Price']//following-sibling::div//p")
	private WebElement priceTag;
	
	

	public FlightConfirmationPage(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory aelf = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(aelf, this);
	}
	
	
	public String getConformationTag() {
		return conformationtag.getText();
	}
	
	public String getPrice() {
		return priceTag.getText();
	}

}
