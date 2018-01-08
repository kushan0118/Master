package org.thcg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProductsObjects {
	
		
	public MyProductsObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public MyProductsObjects() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="menu-item-2661")
	public WebElement HomeMenu;
	
	public void ClickHome()
	{
		HomeMenu.click();
	}
}
