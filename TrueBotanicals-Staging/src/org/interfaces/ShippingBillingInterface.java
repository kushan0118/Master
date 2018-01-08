package org.interfaces;

public interface ShippingBillingInterface {
	
	public void VerifyElement(String Expected);
	
	public void ChangeShippingAddress();
	
	public void SelectShippingMethod();
	
	public void ChangeBillingAddress();
	
	public void AddPaymentMethod();
	
	public void PlaceOrder();

}
