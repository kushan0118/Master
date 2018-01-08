package FirstDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CrossBrowser {
	
	WebDriver driver ;
	
	@BeforeTest
	@Parameters("browser")
	public void SelectBrowser(String BrowserName)
	{
		if(BrowserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./extrafiles/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./extrafiles/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./extrafiles/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		
	}
	
	public String DefaultPath = "http://himalayanstreets.com";
	
	@Test
	public void hiturl()
	{
				
		driver.get(DefaultPath);
		driver.manage().window().maximize();
		
		String actual_title = driver.getTitle();
		String expected_title = "Himalayan Streets";
		
		SoftAssert assertion = new SoftAssert();
		assertion.assertTrue(actual_title.contains(expected_title));
		System.out.println(actual_title);
	}

	@AfterTest
	public void quittest()
	{
		System.out.println("Exiting Test");
		driver.quit();
	}
}
