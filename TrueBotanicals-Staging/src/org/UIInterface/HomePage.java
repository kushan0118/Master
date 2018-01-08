package org.UIInterface;

/**
 * @author Ankush
 *
 */

import java.util.List;

import org.excelmethods.WriteOutputData;
import org.interfaces.HomePageInterface;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
//import org.openqa.selenium.JavascriptExecutor;

public class HomePage implements HomePageInterface{
	
	WebDriver driver;
	WebDriverWait wait;
	SoftAssert assertion = new SoftAssert();
	//String searchtext = "Antioxidant";
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath=".//*[@id='tb-header']/div[1]/div[2]/a/img")  // Get Logo link
	public WebElement logo;
	
	@FindBy(how=How.XPATH,using=".//*[@class='box-copy']//h3") // Get Carousel title text
	public WebElement carousel1title;
	
	@FindBy(how=How.XPATH,using=".//*[@id='home_carousel']/div/div/div[1]/div/div/p[1]") // Get Carousel Description text
	public WebElement carousel1desc;
	
	@FindBy(how=How.LINK_TEXT,using="Learn More")  // Get Carousel button link 
	public WebElement carousel1link;
	
	@FindBy(how=How.CLASS_NAME,using="tb-search-btn")   // Get Search button to open input field for search text
	public WebElement searchbutton;
	
	@FindBy(how=How.NAME,using="q")  // Get search Input Field
	public WebElement searchstring;
	
	@FindBy(how=How.CLASS_NAME, using="nav-link")
	public List<WebElement> NavigationLinks;
	
	@FindBy(how=How.XPATH, using=".//button[@class='close-button' and @data-close-popup='newsletter_sign_up']")
	public WebElement crossNL;
	
	
		
	public void VerifyIdentity(String Expected)
	{
		//String expected ;
		String actual;
		
		actual = logo.getAttribute("src");
		WriteOutputData WOD = new WriteOutputData();
		
		//crossNL.click();
		
		//((JavascriptExecutor) driver).executeScript("scroll(0,800)");		
		if (actual.contains(Expected))
		{
			assertion.assertTrue(true);
			System.out.println("******************Logo is same as expected**************");
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 3, 3, "Pass");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 3, 2, actual);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Home Page" + e.getMessage());
			}
		}
		else {
			assertion.assertTrue(false);
			System.out.println("***************Logo is different than expected= " + actual + "**************");
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 3, 3, "Fail");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 3, 2, actual);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Home Page" + e.getMessage());
			}
		}
		
		//assertion.assertAll();
	}
	
	public void VerifyFirstCarousel(String ExpectedTitle, String ExpectedDesc, String ExpectedLink)
	{
		//String expectedtitle ;
		String actualtitle;
		WriteOutputData WOD = new WriteOutputData();
		
		actualtitle = carousel1title.getText();
		
		if (actualtitle.contains(ExpectedTitle))
		{
			assertion.assertTrue(true);
			System.out.println("*************Title is contains expected text part***********");
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 4, 3, "Pass");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 4, 2, actualtitle);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Home Page" + e.getMessage());
			}
		}
		else {
			assertion.assertTrue(false);
			System.out.println("**************Title missing expected text=" + actualtitle + "**************");
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 4, 3, "Fail");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 4, 2, actualtitle);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Home Page" + e.getMessage());
			}
		}
		
		//String expecteddesc="";
		String actualdesc;
		
		actualdesc=carousel1desc.getText();
		
		if (actualdesc.contains(ExpectedDesc))
		{
			assertion.assertTrue(true);
			System.out.println("*****************Title is contains expected text part****************");
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 5, 3, "Pass");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 5, 2, actualdesc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Home Page" + e.getMessage());
			}
		}
		else {
			assertion.assertTrue(false);
			System.out.println("*****************Title missing expected text= " + actualdesc + "*******************");
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 5, 3, "Fail");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 5, 2, actualdesc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Home Page" + e.getMessage());
			}
		}
		
		//String expectedlink;
		String actuallink="abc";
		
		/*wait= new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(carousel1link));
		actuallink=carousel1link.getAttribute("href");*/
		
		if (actuallink.contains(ExpectedLink))
		{
			assertion.assertTrue(true);
			System.out.println("********************Link contains expected text part= " + actuallink + "**********************");
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 6, 3, "Pass");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 6, 2, actuallink);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Home Page" + e.getMessage());
			}
		}
		else if (actuallink.equals(null))
		{
			System.out.println("****************Link is blank= " + actuallink + "*****************");
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 6, 3, "No Link");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 6, 2, actuallink);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Home Page" + e.getMessage());
			}
		}
		else
		{
			assertion.assertTrue(false);
			System.out.println("********************Link missing expected text= " + actuallink + "*******************");
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 6, 3, "Fail");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 6, 2, actuallink);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Home Page" + e.getMessage());
			}
		}
		//assertion.assertAll();
	}
	
	public void SearchProduct(String SearchText) 
	{
				
		searchbutton.click();  // Click Search Button
		searchstring.sendKeys(SearchText);  // Enter search string
		searchstring.sendKeys(Keys.ENTER); //Press ENTER using keyboard
		System.out.println("*************Product Search request made***********"); // Print in console
		
	}
	
	public void ClickSignIn()
	{
		for (int i=0; i<NavigationLinks.size();i++)
		{
			if(NavigationLinks.get(i).getText().equalsIgnoreCase("Sign In"))
			{
				System.out.println("Click Sign In");
				NavigationLinks.get(i).click();
				break;
			}
			else{
				continue;
			}
		}
	}
	
	

}
