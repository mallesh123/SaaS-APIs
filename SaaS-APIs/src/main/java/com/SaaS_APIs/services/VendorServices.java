package com.SaaS_APIs.services;

import com.SaaS_APIs.dtos.VendorRequest;

public interface VendorServices {
	
	public void uploadVendorFile(VendorRequest vendorFile);
	public void createVendor(VendorRequest vendorFile);
	public void createVendorRequest();
	
	public void deleteVendor(VendorRequest vendorFile);
	public void updateVendor(VendorRequest vendorFile);
	
	

	

}
