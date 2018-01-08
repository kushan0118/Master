package org.UIInterface;

import org.excelmethods.ReadInputData;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

	
@Listeners(org.testNGfiles.TestNGListener.class)
public class MasterClass {
	
	
	//public static String url="https://staging.truebotanicals.com/";
	
	WebDriver driver;
	
	
	
	DefaultMethodsClass defobj = new DefaultMethodsClass(driver); //MainProcessing
	ReadInputData RID = new ReadInputData("D://Ankush Data//drive//recover_1//selenium//data//TBData.xlsx");
	
	@BeforeTest
	public void LaunchingBrowser() 
	{
				
		defobj.InitiateBrowser(RID.GetCellValue(0, 1, 1));   //Test Initiated
		
		Reporter.log("Test log comment", true);
		
		//assertion.assertAll();	
				
	}
	
	@Test(priority=0)
	public void FirstValidate()
	{
		defobj.FirstValidation(RID.GetCellValue(0, 2, 1));  //Crossing primary validation
		//assertion.assertAll();
	}
	
	@Test(priority=1)
	public void ValidateHome()
	{
		defobj.ValidateHome(RID.GetCellValue(0, 3, 1),RID.GetCellValue(0, 4, 1), RID.GetCellValue(0, 5, 1), RID.GetCellValue(0, 6, 1), RID.GetCellValue(0, 7, 1));  //Validating Logo Path in Homepage content
		//assertion.assertAll();
		//assertion.assertAll();
	}
	
	/*@Test(priority=2)
	public void CheckSearch()
	{
		defobj.CheckSearch(RID.GetCellValue(0, 7, 1));   // Search Product
		//assertion.assertAll();
	}
	
	@Test(priority=3)
	public void PDP()
	{
		defobj.Productpage();    // Product Detail Page and add product to Cart
		//assertion.assertAll();
	}
	
	@Test(priority=4)
	public void LoginCheckoutMain()
	{
		defobj.LoginCheckoutClass(RID.GetCellValue(0, 8, 1), RID.GetCellValue(0, 9, 1), RID.GetCellValue(0, 10, 1));
	}
	
	@Test(priority=5)
	public void CartPageMain()
	{
		defobj.CartPageClass(RID.GetCellValue(0, 11, 1));
		defobj.ShippingBillingClass(RID.GetCellValue(0, 12, 1));
	}
	
	@Test(priority=6)
	public void ReviewPage()
	{
		defobj.ReviewPage(RID.GetCellValue(0, 13, 1));
	}*/
	
	@Test(priority=2)
	public void lppage()
	{
		defobj.Login();
	}
	
	@AfterTest
	public void ClosingSession()
	{
		defobj.ClossSession();  //Test Ends
		//assertion.assertAll();
	}
	
	

}
