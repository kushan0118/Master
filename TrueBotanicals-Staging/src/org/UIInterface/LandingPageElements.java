package org.UIInterface;

import org.excelmethods.WriteOutputData;
import org.interfaces.LandingPageInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPageElements implements LandingPageInterface {
	
	WebDriver driver;
	
	public LandingPageElements(WebDriver driver) {
	 this.driver = driver;	
	}
	
	@FindBy(how=How.ID,using="password")   //Finding password input field
	public WebElement entrpwd;
	
	@FindBy(how=How.XPATH,using=".//*[@id='login_form']/div/input")  //Get Enter button
	public WebElement clickentr;
	
	
	public void runmet(String Pass)
	{
		entrpwd.sendKeys(Pass);
		clickentr.click();
		System.out.println("***************Login Successful*******************");
		WriteOutputData WOD = new WriteOutputData();
		
		try {
			WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 2, 3, "Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Landing Page" + e.getMessage());
		}
	}
	
	
	
}
