package com.pronoydas.tests.VendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pronoy.dataprovider.ApplicationDataProvider;
import com.pronoydas.pages.VendorPortal.DashboardPage;
import com.pronoydas.pages.VendorPortal.LoginPage;
import com.pronoydas.pages.VendorPortal.Model.VendorPortalModel;
import com.pronoydas.tests.BaseTest;
import com.pronoydas.utility.JacksonUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VendorPortalTest extends BaseTest{
	
	
	        
	
	


//    @BeforeMethod
//    public void setPageObjects(String testDataPath){
//    	WebDriverManager.chromedriver().setup();
//    	driver = new ChromeDriver();
//    	driver.manage().window().maximize();
//    	driver.get("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
//    }


    @Test(dataProvider = "VendorDetails", dataProviderClass = ApplicationDataProvider.class)
    public void loginTest(VendorPortalModel vpm){
        LoginPage lp = new LoginPage(driver);
        lp.doLogin(vpm.getUsername(), vpm.getPassword());
        DashboardPage dp = new DashboardPage(driver);
        String userName=dp.getUserDetails();
        Assert.assertEquals(vpm.getUsername(), userName.toLowerCase());
        dp.logout();
    }

    @Test(dataProvider = "VendorDetails", dataProviderClass = ApplicationDataProvider.class)
    public void dashboardTest(VendorPortalModel vpm){
    	
    	 LoginPage lp = new LoginPage(driver);
         lp.doLogin(vpm.getUsername(), vpm.getPassword());
         DashboardPage dp = new DashboardPage(driver);
         
         
         
         Assert.assertEquals(vpm.getMonthlyEarning(), dp.getMonthlyEarning());
         Assert.assertEquals(vpm.getAnnualEarning(), dp.getAnnualEarning());
         Assert.assertEquals(vpm.getProfitMargin(), dp.getProfitMargin());
         Assert.assertEquals(vpm.getAvailableInventory(), dp.getAvailableInventory());
         
         
 
        // order history search
        dp.searchOrderHistoryBy("sam");
        System.out.println(dp.getSearchResultsCount());
//        Assert.assertEquals(dashboardPage.getSearchResultsCount(), testData.searchResultsCount());
    }
//
    @Test(dataProvider = "VendorDetails", dataProviderClass = ApplicationDataProvider.class)
    public void logoutTest(VendorPortalModel vpm){
    	 LoginPage lp = new LoginPage(driver);
    	 lp.doLogin(vpm.getUsername(), vpm.getPassword());
         DashboardPage dp = new DashboardPage(driver);
         dp.logout();
       
    }

}
