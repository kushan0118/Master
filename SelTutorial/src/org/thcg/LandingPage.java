package org.thcg;

import org.DDT.ExcelData;
import org.defaultclasses.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPage {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		ExcelData edata = new ExcelData("D:/data/SiteLinks.xls"); //Open Excel Sheet
		
		System.setProperty("webdriver.chrome.driver", "./extrafiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		ScreenShot snaps = new ScreenShot();
		
		driver.navigate().to(edata.ReadCell("SitePath", 1));
		snaps.screeshot("./Snapshots/home.png");
		//object for the page
		LandingPageObjects page = new LandingPageObjects(driver);
		page.VerifyHome(); //Verify Logo and text
		page.ClickMyproducts();
		
		//Add Wait Time
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Making relation between two page objects
		MyProductsObjects Programs = new MyProductsObjects(driver);
		
		Programs.ClickHome();
		
		driver.quit();
		
	}

}
