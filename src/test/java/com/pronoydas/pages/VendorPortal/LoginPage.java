package com.pronoydas.pages.VendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.pronoydas.pages.BasePage;

public class LoginPage extends BasePage{
	
	
	@FindBy(id = "username")
	private WebElement userName;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "login")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory aelf = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(aelf, this);
	}
	
	
	public void doLogin(String userName, String pass) {
		this.userName.sendKeys(userName);
		this.password.sendKeys(pass);
		loginBtn.click();
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
