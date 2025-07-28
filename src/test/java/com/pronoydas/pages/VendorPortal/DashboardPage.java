package com.pronoydas.pages.VendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pronoydas.pages.BasePage;

public class DashboardPage extends BasePage{
	
	
	
	@FindBy(id = "monthly-earning")
	private WebElement monthlyEarning;
	
	@FindBy(id = "annual-earning")
	private WebElement annualEarning;
	
	@FindBy(id = "profit-margin")
	private WebElement profitMargin;
	
	@FindBy(id = "available-inventory")
	private WebElement availableInventory;
	
	@FindBy(xpath = "//a[@id='userDropdown']/span")
	private WebElement userDetails;
	
	@FindBy(xpath = "//label[text()='Search:']//child::input")
	private WebElement searchBox;
	
    @FindBy(css = "#dataTable_filter input")
    private WebElement searchInput;

    @FindBy(id = "dataTable_info")
    private WebElement searchResultsCountElement;

    @FindBy(css = "img.img-profile")
    private WebElement userProfilePictureElement;

    // prefer id / name / css
    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(css = "#logoutModal a")
    private WebElement modalLogoutButton;
	
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory aelf = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(aelf, this);
	}
	
	
	public String getUserDetails() {
		return userDetails.getText();
	}
	
	  public String getMonthlyEarning(){
	        return this.monthlyEarning.getText();
	    }

	    public String getAnnualEarning(){
	        return this.annualEarning.getText();
	    }

	    public String getProfitMargin(){
	        return this.profitMargin.getText();
	    }

	    public String getAvailableInventory(){
	        return this.availableInventory.getText();
	    }

	    public void searchOrderHistoryBy(String keyword){
	        this.searchInput.sendKeys(keyword);
	    }
	    
	    public int getSearchResultsCount(){
	        String resultsText = this.searchResultsCountElement.getText();
	        String[] arr = resultsText.split(" ");
	        // if we do not have 5th item, it would throw exception.
	        // that's fine. we would want our test to fail anyway in that case!
	        int count = Integer.parseInt(arr[5]);
	        //log.info("Results count: {}", count);
	        return count;
	    }

	    public void logout(){
	        this.userProfilePictureElement.click();
	        this.wait.until(ExpectedConditions.visibilityOf(this.logoutLink));
	        this.logoutLink.click();
	        this.wait.until(ExpectedConditions.visibilityOf(this.modalLogoutButton));
	        this.modalLogoutButton.click();
	    }

}
