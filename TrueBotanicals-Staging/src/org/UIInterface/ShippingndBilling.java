package org.UIInterface;

import java.util.List;

import org.excelmethods.WriteOutputData;
import org.interfaces.ShippingBillingInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingndBilling implements ShippingBillingInterface{
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ShippingndBilling(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	//Locating Main Heading of the Page, Wait element for script
	@FindBy(how=How.XPATH, using=".//div[@id='pagination']//h2[@class='title-left']")
	public WebElement VerifyHeading;
	//Location all divs listed under Billing Section
	@FindBy(how=How.XPATH, using=".//div[@id='shipping_container']//div//div")
	public List<WebElement> ShippingSectionDivs;
	//Location of current address
	@FindBy(how=How.ID, using="current-address")
	public WebElement CurrentAddress;
	//Click to expand Shipping Section
	@FindBy(how=How.CLASS_NAME, using="accordion-button")
	public WebElement ExpandShippingSection;
	//List of all shipping addresses
	@FindBy(how=How.XPATH, using=".//*[@id='addresses-list']/li")
	public List<WebElement> AddressesList;
	//Location to enter new address
	@FindBy(how=How.ID, using="showShipmentForm")
	public WebElement EntrNewAddress;
	//Locating Address Fist Name field
	@FindBy(how=How.ID, using="checkout_shipping_address_first_name")
	public WebElement ShippingAddressFN;
	//Locating Address Last Name field
	@FindBy(how=How.ID, using="checkout_shipping_address_last_name")
	public WebElement ShippingAddressLN;
	//Locating Address field line 1
	@FindBy(how=How.ID, using="checkout_shipping_address_address1")
	public WebElement ShippingAddressLine1;
	//Locating Address field line 2
	@FindBy(how=How.ID, using="checkout_shipping_address_address2")
	public WebElement ShippingAddressLine2;
	//Locating Address field city
	@FindBy(how=How.ID, using="checkout_shipping_address_city")
	public WebElement ShippingAddressCity;
	//Locating Address field Country
	@FindBy(how=How.ID, using="checkout_shipping_address_country")
	public List<WebElement> ShippingAddressCountry;
	//Locating Address field State
	@FindBy(how=How.ID, using="checkout_shipping_address_province")
	public List<WebElement> ShippingAddressState;
	//Locating Address field Zip
	@FindBy(how=How.ID, using="checkout_shipping_address_zip")
	public WebElement ShippingAddressZip;
	//Locating Address field cross and submit button
	@FindBy(how=How.XPATH, using=".//div[@id='shippingAddressModal']//button")
	public WebElement ShippingAddressSubmit;
	//Locating Shipping Method Checkbox
	@FindBy(how=How.XPATH, using=".//div[@id='expedite-shipping-options']//input")
	public List<WebElement> ShippingCheckBox;
	//Locating Shipping Method Label
	@FindBy(how=How.XPATH, using=".//div[@id='expedite-shipping-options']//label")
	public List<WebElement> ShippingLabel;
	//Locating Shipping Method Price
	@FindBy(how=How.XPATH, using=".//div[@id='expedite-shipping-options']//span")
	public List<WebElement> ShippingPrice;
	//Locating Shipping error text element
	@FindBy(how=How.ID, using="shipping_error")
	public WebElement ShippingErrorMessage;
	//Locating selection radio button for Credit card
	@FindBy(how=How.XPATH, using=".//div[@id='allcreditcards']//img")
	public List<WebElement> SelectCard;
	//Locating CC image showing up
	@FindBy(how=How.XPATH, using=".//div[@id='allcreditcards']//img")
	public List<WebElement> CardImg;
	//Location of add new to add payment method
	@FindBy(how=How.XPATH, using=".//*[@id='credit-card-new']/a")
	public WebElement CreditCardNew;
	//Locating input field for card number (IFRAME)
	@FindBy(how=How.ID, using="credit-card-number")
	public WebElement CardNumber;
	//Locating input field for expiration date (format accepted: MM/YY)
	@FindBy(how=How.ID, using="expiration")
	public WebElement CardExpiration;
	//Locating input field for CVV number
	@FindBy(how=How.ID, using="cvv")
	public WebElement CVVNumber;
	//Locating PayPal button for placing order through PayPal
	@FindBy(how=How.XPATH, using=".//div[@aria-label='paypal']")
	public WebElement PayPalButton;
	//Locating Checkbox to enter billing address (if different than shipping address)
	@FindBy(how=How.ID, using="checkout_different_billing_address")
	public WebElement ClickforDifferentBillingAddress;
	//locating current billing address value
	@FindBy(how=How.ID, using="current-billing-address")
	public WebElement CurrentBillingAddress;
	//Locating checkout billing checkbox
	@FindBy(how=How.ID, using="checkout_different_billing_address")
	public WebElement CheckoutBilling;
	//locating Review button and to continue payment with CC info
	@FindBy(how=How.ID, using="reviewbtn")
	public WebElement ClickReview;
	
	
	public void VerifyElement(String Expected)
	{
		//Add wait for element and check for visibility
		wait = new WebDriverWait(driver, 3);
		
		wait.until(ExpectedConditions.visibilityOf(VerifyHeading));
		
		String actual = VerifyHeading.getText();
		WriteOutputData WOD = new WriteOutputData();
		//String expected = "";
		
		if(actual.contains(Expected))
		{
			System.out.println("**********Heading Present: " + actual + " **************");
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 12, 3, "Pass");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 12, 2, actual);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Shipping and Billing Page" + e.getMessage());
			}
		}
		else{
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 12, 3, "Fail");
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 12, 2, actual);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Shipping and Billing Page" + e.getMessage());
			}
			System.out.println("**********Heading Not Found: " + actual + " **************");
		}
		
		
	}
	
	public void ChangeShippingAddress()
	{
		//Change shipping address or add new
		System.out.println("*******Current Selected Shipping Address*********");
		System.out.println(CurrentAddress.getText());
		
		ExpandShippingSection.click();
			for(int i=0;i<AddressesList.size();i++)
			{
				System.out.println("Shipping Address No." + i + AddressesList.get(i).getText());
				
					if(AddressesList.get(i).getText().contains("Add address"))
					{
						EntrNewAddress.click();
						
						wait.until(ExpectedConditions.visibilityOf(ShippingAddressFN));
						ShippingAddressFN.sendKeys("Ankush" + i);
						ShippingAddressLN.sendKeys("Sharma" + i);
						ShippingAddressLine1.sendKeys("Casa Blanca" + "#" + i);
						ShippingAddressLine2.sendKeys("test" + i);
						ShippingAddressCity.sendKeys("California");
							for(int j=0;j<ShippingAddressCountry.size();j++)
							{
								WebElement ShippingCountry = ShippingAddressCountry.get(j);
								if(ShippingCountry.getText().contains("United States"))
								{
									ShippingCountry.click();
								}
							}
							for(int j=0;j<ShippingAddressState.size();j++)
							{
								WebElement ShippingState = ShippingAddressState.get(j);
								if(ShippingState.getText().contains("California"))
								{
									ShippingState.click();
								}
							}
						ShippingAddressZip.sendKeys("19500");
						ShippingAddressSubmit.click();
						break;
					}
			}
		
	}
	
	public void SelectShippingMethod()
	{
		//Select Shipping Method from available options
		
		for(int i=0;i<ShippingCheckBox.size();i++)
		{
			System.out.println(ShippingLabel.get(i).getText() + " : " + ShippingPrice.get(i).getText());
			String ShippingMethod = ShippingCheckBox.get(i).getAttribute("value");
				if(ShippingMethod.equals("0"))
				{
					ShippingCheckBox.get(i).click();
					break;
				}
				
		}
	}
	
	public void ChangeBillingAddress()
	{
		//Select Billing Address or add new
		System.out.println("Billing Address : " + CurrentBillingAddress.getText());
	}
	
	public void AddPaymentMethod()
	{
		
		CreditCardNew.click();
		
		driver.switchTo().frame("braintree-hosted-field-number");
		wait.until(ExpectedConditions.visibilityOf(CardNumber));
		CardNumber.sendKeys("4111111111111111");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("braintree-hosted-field-expirationDate");
		CardExpiration.sendKeys("12/22");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("braintree-hosted-field-cvv");
		CVVNumber.sendKeys("123");
		
		driver.switchTo().defaultContent();
	}
	
	public void PlaceOrder()
	{
		//Enter/Select Details and place order
		System.out.println("******************* Order Details ******************");
		System.out.println();
		System.out.println("Shipping Address : " + CurrentAddress.getText());
		//SelectCard.click();
			for(int i=0;i<SelectCard.size();i++)
			{
				String CardNum = SelectCard.get(i).getAttribute("alt");
				System.out.println(CardNum);
					if(CardNum.equals("Visa"))
					{
						SelectCard.get(i).click();
						
					}
			}
		System.out.println();
		if(CheckoutBilling.isSelected())
		{
			System.out.println("Checkbox is Selected");
		}
		else{
			CheckoutBilling.click();
		}
		
		ClickReview.click();
	}
	
	
}
