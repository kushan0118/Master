package org.UIInterface;

/**
 * @author Ankush
 *
 */

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locating forgot and sign up elements on page
	@FindBy(how=How.XPATH, using=".//div[@id='customer_login']//strong")
	public List<WebElement> LoginOption;
	
	@FindBy(how=How.XPATH, using=".//button[@class='close-button' and @data-close-popup='newsletter_sign_up']")
	public WebElement crossNL;
	
	@FindBy(how=How.XPATH, using=".//*[@class='title-container']//h4")
	public WebElement MainHead;
	
	@FindBy(how=How.ID, using="first_name_r")
	public WebElement Fname;
	
	@FindBy(how=How.ID, using="last_name_r")
	public WebElement Lname;
	
	@FindBy(how=How.ID, using="email_r")
	public WebElement Email;
	
	@FindBy(how=How.ID, using="password_r")
	public WebElement Pword;
	
	@FindBy(how=How.XPATH, using=".//div[@id='password']//input[@type='button']")
	public WebElement Submit;
	
	
	
	public void ClickSignUp()
	{
		wait = new WebDriverWait(driver, 5);
		
		for (int i=0;i<LoginOption.size();i++)
		{
			wait.until(ExpectedConditions.elementToBeClickable(LoginOption.get(i)));
			crossNL.click();
			System.out.println(LoginOption.get(i).getText());
			if(LoginOption.get(i).getText().equalsIgnoreCase("Sign Up"))
			{
				LoginOption.get(i).click();
				try {
					wait.until(ExpectedConditions.textToBePresentInElement(MainHead, "I’M A NEW CUSTOMER."));
														
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				
				
				break;
			}
			else {
				continue;
			}
		}
		
	}
	
	
	

}
