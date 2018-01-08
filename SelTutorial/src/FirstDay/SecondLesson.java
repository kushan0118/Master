package FirstDay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SecondLesson {
	
	public WebDriver driver;
	
	@BeforeTest
	public void SetBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./extrafiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("=============Browser Initialized=============");
	}
	
	public String DefaultPath = "http://himalayanstreets.com";
	
	@Test
	public void geturl()
	{
		driver.get(DefaultPath);
		String PageSrc = driver.getPageSource();
		String PageTitle = driver.getTitle();
		String ExpectedTitle = "Blogs | Photography | Daily Thoughts | Travelling - By Himalayan Streets";
			
		Assert.assertTrue(PageTitle.contains(ExpectedTitle), "Page Title MisMatched");
			boolean Status = driver.findElement(By.xpath(".//*[@id='post-156']/h2")).isDisplayed();
			Assert.assertTrue(Status);
			SoftAssert assertion = new SoftAssert();
			assertion.assertEquals(10, 10,"Values Matched");
			if (PageSrc.contains("UA-100429460-1"))
					{
				System.out.println("Google Analytic added " + "UA-100429460-1");
					}
			else{
				System.err.println("Google Analytic code missing");
			}
	}
	
	@AfterClass
	public void QuitDriver()
	{
		driver.quit();
		System.out.println("==================Closing Browser================");
	}
}
