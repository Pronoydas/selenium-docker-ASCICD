package com.pronoydas.pages.FilghtBooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.pronoydas.pages.BasePage;
import com.pronoydas.utility.FakerUtility;

public class RegistrationPage extends BasePage{
	
	private WebDriver driver ;
	
	@FindBy(id = "firstName")
	private WebElement fristName;
	
	@FindBy(id = "lastName")
	private WebElement lastName ;
	//email
	
	@FindBy(id = "email")
	private WebElement email ;
	
	@FindBy(id = "password")
	private WebElement password;
	
	//inputState
	
	@FindBy(id = "inputState")
	private WebElement stateDropDown;
	
	@FindBy(id = "register-btn") 
	private WebElement registerBtn;
	
	
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory aelf=new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(aelf, this);
		
	}
	
	public RegistrationPage enterFullName() {
		fristName.sendKeys(FakerUtility.getFristName());
		lastName.sendKeys(FakerUtility.getLastName());
		return this ;
	}
	
	public RegistrationPage enterEmail() {
		email.sendKeys(FakerUtility.getEemail());
		return this;
	}
	
	public RegistrationPage enterPassword() {
		password.sendKeys(FakerUtility.generatePassword());
		return this ;
	}
	
	public RegistrationPage selectState() {
		Select s = new Select(stateDropDown);
		s.selectByIndex(3);
		return this;
	}
	//
	public RegistrationConfirmationPage clickOnRegisterBtn(WebDriver driver) {
		registerBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RegistrationConfirmationPage(driver);
	}
	
	

}
