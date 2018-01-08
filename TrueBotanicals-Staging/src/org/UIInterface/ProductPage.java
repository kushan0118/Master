package org.UIInterface;

import java.util.Iterator;
import java.util.List;

import org.interfaces.ProductPageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage implements ProductPageInterface{
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ProductPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	@FindBy(how=How.CLASS_NAME,using="product-name")
	public WebElement ProductName;
	
	@FindBy(how=How.CLASS_NAME, using ="product-price")
	public WebElement ProductPrice;
	
	@FindBy(how=How.CLASS_NAME,using="product-description")
	public WebElement ProductDesc;
	
	@FindBy(how=How.CLASS_NAME,using="product-bullets")
	public WebElement ProductBullets;
	
	@FindBy(how=How.CLASS_NAME,using="delivery-option")
	public List<WebElement> ProductDeliveryOpt;
	
	@FindBy(how=How.XPATH,using="//input[@name='subType']")
	public List<WebElement> SubscriptionType;
	
	@FindBy(how=How.XPATH,using="//button[@type='submit' and @data-id='11542682822']")
	public WebElement SubmitCart;
	
	@FindBy(how=How.ID,using="addedToCartAjaxModal")
	public WebElement AjaxCartConf;
	
	@FindBy(how=How.XPATH,using=".//a[@title='Your cart']")
	public WebElement ShopingBag;
	
	public void ProductCollection()
	{
		System.out.println("");
		System.out.println("************Product Collection**************");
		System.out.println("Product Name = " + ProductName.getText());
		System.out.println("Product Price = " + ProductPrice.getText());
		System.out.println("Product Description = " + ProductDesc.getText());
		System.out.println("Bullet Points = " + ProductBullets.getText());
		
		Iterator<WebElement> DelOpt = ProductDeliveryOpt.iterator();
		
		while (DelOpt.hasNext())
		{
			WebElement DelOptVal = DelOpt.next();
			String OptValue = DelOptVal.getText();
			System.out.println("Main Delivery Options = " + OptValue);
			
			if (OptValue.startsWith("4"))
			{
				DelOptVal.click();
				//itr.next().click();
				List<WebElement> DeliveryFreq = driver.findElements(By.xpath(".//*[@class='selectize-dropdown-content']//div"));
				
				Iterator<WebElement> DelFq = DeliveryFreq.iterator();
				
				while (DelFq.hasNext())
				{
					String FqVal = DelFq.next().getText();
					System.out.println("Delivery Frequency Value = " + FqVal);
					//System.out.println("test");
				}
			}
			
			
		
		}
		System.out.println("************END**************");
		System.out.println("");
	}
	
	public void AddProductToCart ()
	{
		System.out.println("***********Adding Product To Cart**************");
		//Select Order Type Subscription or Normal
		for(int i=0;i<SubscriptionType.size();i++)
		{
			WebElement Subscription = SubscriptionType.get(i);
			
			String SubscriptionVal = Subscription.getAttribute("value");
			
			if (SubscriptionVal.equals("2"))  // Selecting Subscription Order, Value '1' for normal order
			{
				Subscription.click();
				System.out.println("Subscription type selected for Product");
			}
		}
		
		// Select Subscription Frequency
		
		Iterator<WebElement> DelOpt = ProductDeliveryOpt.iterator();
		
		while (DelOpt.hasNext())
		{
			WebElement DelOptVal = DelOpt.next();
			String OptValue = DelOptVal.getText();
			//System.out.println("Main Delivery Options: " + OptValue);
			
			if (OptValue.startsWith("4"))
			{
				DelOptVal.click();
				//itr.next().click();
				List<WebElement> DeliveryFreq = driver.findElements(By.xpath(".//*[@class='selectize-dropdown-content']//div"));
				
				for (int i=0;i<DeliveryFreq.size();i++)
				{
					WebElement DeliveryOpt = DeliveryFreq.get(i);
					String DeliveryOptVal = DeliveryOpt.getAttribute("data-value");
					
					if (DeliveryOptVal.equals("2"))
					{
						DeliveryOpt.click();
					}
				}
			}
			
			
		
		}
		
		SubmitCart.click();
		
		//Wait<WebDriver> Sleep = new WebDriverWait(driver, 5);
		
		//Sleep.until(ExpectedConditions.presenceOfElementLocated((By) AjaxCartConf));
		wait = new WebDriverWait(driver, 5);
		
		wait.until(ExpectedConditions.visibilityOf(AjaxCartConf));
		System.out.println("Ajax Confirmation Popup appeared with message as = " + AjaxCartConf.getText().trim());
		
		String []count = AjaxCartConf.getText().trim().split(" ");
		
		for (int k=0; k<count.length;k++)
		{
			System.out.println(count[k]);
			
		}
		
		
		System.out.println("**********************Product Added to Cart********************");
		System.out.println("");
		
		
	}
	
	public void VerifyCart()
	{
		System.out.println("Cart Product count = " + ShopingBag.getText());
		
		ShopingBag.click();
	}
	
	
}
