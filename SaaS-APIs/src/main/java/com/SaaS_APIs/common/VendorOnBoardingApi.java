package com.SaaS_APIs.common;

import java.io.IOException;

import java.security.GeneralSecurityException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;


import com.SaaS_APIs.utils.TokenProducer;
import com.SaaS_APIs.dtos.UserAccount;
import com.SaaS_APIs.dtos.VendorRequest;
import com.SaaS_APIs.services.VendorServices;

public class VendorOnBoardingApi implements com.SaaS_APIs.services.VendorServices{
	
	VendorRequest vrequestContainer;
	private String testAccountUsername;
	private TokenProducer tokenProducer;
	
	public VendorOnBoardingApi(VendorRequest vrq) throws Exception{
	
		this.vrequestContainer=vrq;
	}
	
	private synchronized void initVendorConfiguration(UserAccount userAccount) throws Exception {

		if(userAccount != null) {

			String bundleName =  "com.vendorOnBoarding.properties.vendorconnection";
			
			if (userAccount.getRole() != null) {
				bundleName +=  userAccount.getRole().toLowerCase();
			} 

			ResourceBundle rb = ResourceBundle.getBundle(bundleName);
			this.tokenProducer = new com.SaaS_APIs.utils.TokenProducer(rb.getString("clientid"), rb.getString("clientsecret"),
					rb.getString("clientsecret"), rb.getString("refreshtoken"));

			/*box = new Box(tokenProducer, userAccount);
			if (!box.initAccessTokenByRefreshTokenAndClientId()) {
				System.out.println("Required parameters are missing from the properties file");
			}

		} else {
			throw new Exception ("Unsupported Role");
		}*/
		}

	}
	
	
	public VendorOnBoardingApi( UserAccount userAccount) throws Exception {		
		Reporter.log("VendorOnBoardingApi initialized", true);
		this.testAccountUsername=userAccount.getUsername();

	
		Reporter.log("#######################################", true);
		Reporter.log("***** account name:"+ this.testAccountUsername, true);
		Reporter.log("#######################################", true);
		
		initVendorConfiguration(userAccount);


		/*if (application.equalsIgnoreCase("BOX" )) {

			if (userAccount.getUserType().equals("EXTERNAL")) {
				Reporter.log("Initializing the configuration for box external user...", true);
				this.initExternalUserBoxConfiguration(userAccount);
			} else {
				Reporter.log("Initializing the configuration for box...", true);
				initBoxConfiguration(userAccount);
			}
		}

		
		*/

	}

	public void uploadVendorFile(VendorRequest vendorFile) {
		// TODO Auto-generated method stub
		
	}

	public void createVendor(VendorRequest vendorFile) {
		// TODO Auto-generated method stub
		
	}

	public void createVendorRequest() {
		// TODO Auto-generated method stub
		
	}

	public void deleteVendor(VendorRequest vendorFile) {
		// TODO Auto-generated method stub
		
	}

	public void updateVendor(VendorRequest vendorFile) {
		// TODO Auto-generated method stub
		
	}
	
	

}
