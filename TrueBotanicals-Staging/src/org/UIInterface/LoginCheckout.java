package org.UIInterface;

/**
 * @author Ankush
 *
 */

import org.excelmethods.WriteOutputData;
import org.interfaces.LoginCheckoutInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginCheckout implements LoginCheckoutInterface{
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginCheckout(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	@FindBy(how=How.CLASS_NAME, using="title-container")
	public WebElement VerifyText;
	
	@FindBy(how=How.XPATH,using=".//form[@id='customer_login']//div[@id='email']//input")
	public WebElement EntrEmail;
	
	@FindBy(how=How.XPATH,using=".//form[@id='customer_login']//div[@id='password']//input[@id='password']")
	public WebElement EntrPassword;
	
	@FindBy(how=How.XPATH, using=".//form[@id='customer_login']//div[@id='password']//input[@type='submit']")
	public WebElement ClickSubmit;
	
	
	public void LoggingIn(String ExpectedText, String Uname, String Pword)
	{
		//String ExpectedText = "";
		WriteOutputData WOD = new WriteOutputData();
		wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOf(VerifyText));
		
		if (VerifyText.getText().equalsIgnoreCase(ExpectedText))
		{
			EntrEmail.sendKeys(Uname);
			
			
			EntrPassword.sendKeys(Pword);
			
			ClickSubmit.click();
			
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 8, 3, "Pass");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 8, 2, VerifyText.getText());
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 9, 3, "Pass");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 10, 3, "Pass");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Login checkout Page" + e.getMessage());
			}
			
		}
		else {
			System.out.println("Sign In Option Not Found" + VerifyText.getText());
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 8, 3, "Fail");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 8, 2, VerifyText.getText());
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 9, 3, "Fail");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 10, 3, "Fail");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Login checkout Page" + e.getMessage());
			}
		}
		
	}
}
