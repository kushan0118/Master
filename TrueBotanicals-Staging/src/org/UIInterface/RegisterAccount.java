package org.UIInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterAccount {
	
	WebDriver driver;
	
	public RegisterAccount(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(how=How.ID, using="first_name_r")
	public WebElement Fname;
	
	@FindBy (how=How.ID, using="last_name_r")
	public WebElement Lname;
	
	@FindBy(how=How.ID, using="email_r")
	public WebElement Email;
	
	@FindBy(how=How.ID, using="password_r")
	public WebElement Pword;
	
	
	
}
