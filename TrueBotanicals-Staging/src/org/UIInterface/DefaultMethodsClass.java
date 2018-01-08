package org.UIInterface;

import org.excelmethods.WriteOutputData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class DefaultMethodsClass {
	
	
	WebDriver driver;
	
	public DefaultMethodsClass(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebDriver InitiateBrowser(String path)
	{
		
		
		System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver.exe");
		
		driver = new ChromeDriver();  //Browser Initiated
		
		driver.manage().window().maximize();
		
		driver.get(path);      //URL Loaded
		
		//System.out.println(driver);
		
		WriteOutputData WOD = new WriteOutputData();
		
		try {
			WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 1, 2, driver.toString());
			WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 1, 3, "Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Home Page" + e.getMessage());
		}
		
		return(driver);
	}
	
	public void FirstValidation(String Pass)
	{
		
		LandingPageElements lpeobj = PageFactory.initElements(driver, LandingPageElements.class);
		lpeobj.runmet(Pass);      //Logging In
				
	}
	
	public void ValidateHome(String ExpectedLogoPath, String ExpectedTitle, String ExpectedDesc, String ExpectedLink, String SearchText)
	{
		
		HomePage hpobj = PageFactory.initElements(driver, HomePage.class);
		hpobj.VerifyIdentity(ExpectedLogoPath);   // Validate Logo
		//hpobj.VerifyFirstCarousel(ExpectedTitle, ExpectedDesc, ExpectedLink); // Validate Carousel Image content
		//hpobj.SearchProduct(SearchText); // Search Product name
		hpobj.ClickSignIn(); //Click Sign In nav link
	}
	
	public void Login()
	{
		LoginPage lpobj = PageFactory.initElements(driver, LoginPage.class);
		lpobj.ClickSignUp();
	}
	
	public void CheckSearch(String SearchText)
	{
		SearchResultPage srpobj=PageFactory.initElements(driver, SearchResultPage.class);
		srpobj.getresults(SearchText);   // Search result page
	}
	
	public void Productpage()
	{
		ProductPage ppobj = PageFactory.initElements(driver, ProductPage.class);
		ppobj.ProductCollection();  // Product details Page get details
		ppobj.AddProductToCart(); //Enter Details and click Add to cart
		ppobj.VerifyCart(); //Verify Cart
	}
	
	public void LoginCheckoutClass(String ExpectedText, String Uname, String Pword)
	{
		LoginCheckout lcobj = PageFactory.initElements(driver, LoginCheckout.class);
		
		lcobj.LoggingIn(ExpectedText, Uname, Pword);
	}
	
	public void CartPageClass(String VerifyText)
	{
		CartPage cpobj = PageFactory.initElements(driver, CartPage.class);
		
		cpobj.VerifyProductList(VerifyText);
		cpobj.VerifyOrderSummary();
		//cpobj.VerifyDiscoutCards();
		cpobj.Checkout();
	}
	
	public void ShippingBillingClass(String Expected)
	{
		ShippingndBilling sabobj = PageFactory.initElements(driver, ShippingndBilling.class);
		sabobj.VerifyElement(Expected);
		sabobj.PlaceOrder();
		//sabobj.ChangeShippingAddress();
		//sabobj.AddPaymentMethod();
	}
	
	public void ReviewPage(String expected)
	{
		OrderReviewPage orpobj = PageFactory.initElements(driver, OrderReviewPage.class);
		orpobj.VerifyText(expected);
		orpobj.PlaceOrder();
	}
	
	public void ClossSession()
	{
		driver.quit();   //Exiting the browser
	}
}
