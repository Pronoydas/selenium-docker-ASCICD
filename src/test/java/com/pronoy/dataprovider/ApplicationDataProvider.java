package com.pronoy.dataprovider;

import org.testng.annotations.DataProvider;

import com.pronoydas.pages.VendorPortal.Model.VendorPortalModel;
import com.pronoydas.utility.JacksonUtil;

public class ApplicationDataProvider {
	
	
	@DataProvider(name = "VendorDetails")
	public Object[] getVendorDetails() {
		
		VendorPortalModel vpm = JacksonUtil.readJson("Test-Data//Vendor_Portal_Jhon.json", VendorPortalModel.class);
		VendorPortalModel vpm1 = JacksonUtil.readJson("Test-Data//Vendor_Portal_Mike.json", VendorPortalModel.class);
		VendorPortalModel vpm3 = JacksonUtil.readJson("Test-Data//Vendor_Portal_Sam.json", VendorPortalModel.class);
		
		Object [] obj = new Object[3];
		obj[0]=vpm;
		obj[1]=vpm1;
		obj[2]=vpm3;
		
		return obj;
	}

}
