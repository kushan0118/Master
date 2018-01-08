package org.thcg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObjects {
	
	//Initialize my objects in the page
	public LandingPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="logo")
	public WebElement logo;
	@FindBy(className="et_pb_testimonial_description_inner")
	public WebElement testimonial;
	@FindBy(xpath=".//*[@id='menu-item-2791']/a")
	public WebElement MyProducts;
	
	//Method Declare
	public void VerifyHome()
	{
		//Search for the logo
		System.out.println(logo.getAttribute("src"));
		//Search for the text
		System.out.println(testimonial.getText());		
	}
	
	public MyProductsObjects ClickMyproducts()
	{
		MyProducts.click();
		return new MyProductsObjects();
	}
	
}
