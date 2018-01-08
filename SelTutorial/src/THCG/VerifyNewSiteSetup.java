package THCG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyNewSiteSetup extends VariablesLog {
	
	WebDriver driver ; //Public Variables
	
	//VerifyNewSiteSetup obj = new VerifyNewSiteSetup();
		
	@BeforeTest 
	@Parameters("browser") 
	
	public void setbrowser(String BrowserName)
	{
		
		if(BrowserName.equalsIgnoreCase(browserone))
		{
			System.setProperty(browseronepropertytype, browseronepropertypath);
			driver = new FirefoxDriver();
			//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}
		else if(BrowserName.equalsIgnoreCase(browsertwo))
		{
			System.setProperty(browsertwopropertytype, browsertwopropertypath);
			driver = new ChromeDriver();
			//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else if(BrowserName.equalsIgnoreCase(browserthree))
		{
			System.setProperty(browserthreepropertytype, browserthreepropertypath);
			driver = new InternetExplorerDriver();
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	}
	
	
	SoftAssert Assertion = new SoftAssert();
	
	
	@Test(priority=1)
	public void gethome()
	{
		driver.get(DefaultPath); //Call default path
		
	}
	
	@Test(priority=2 , dependsOnMethods="gethome")
	public void VerifyHome()
	{
		String HomePageTitle = driver.getTitle();
				//Check for the title content
					if(HomePageTitle.contains(HomeExpected_title))
					{
						Assertion.assertTrue(false, HomePageassertfirst + HomePageTitle);
					}
					else{
						Assertion.assertTrue(false, HomePageassertsecond + HomePageTitle);
					}
					
				//Check for Logo
				WebElement LogoElement = driver.findElement(By.xpath(LogoElementxpath));
				String logoSrc = LogoElement.getAttribute("src");
				
					if(logoSrc.contains(Default_logo))
					{
						Assertion.assertTrue(false, LogoElementAssertFirst + logoSrc);
					}
					else{
						Assertion.assertTrue(false, LogoElementAssertSecond + logoSrc);
					}
					
					
	}
	
	@Test(priority = 3 , dependsOnMethods="gethome")
	public void VerifyPageSource()
	{
		String PageSource = driver.getPageSource(); //Get PageSource
		
		//Check for the content in source
			if (PageSource.contains(Testimonial_Part))
			{
				Assertion.assertEquals(false, PageSourceAssertone);
			}
			else{
				Assertion.assertEquals(true, PageSourceAsserttwo);
			}
			Assertion.assertAll();
					
	}
	
	
	
	
	@AfterTest 
		
	public void ApplicationQuit()
	{
		
		driver.quit();
	}
	

}
