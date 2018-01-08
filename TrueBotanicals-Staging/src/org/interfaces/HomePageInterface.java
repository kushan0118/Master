package org.interfaces;

public interface HomePageInterface {
	
	public void VerifyIdentity(String Expected);
	public void VerifyFirstCarousel(String ExpectedTitle, String ExpectedDesc, String ExpectedLink);
	public void SearchProduct(String SearchText);

}
