package org.UIInterface;

/**
 * @author Ankush
 *
 */

import java.util.List;

import org.excelmethods.WriteOutputData;
import org.interfaces.CartPageInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage implements CartPageInterface {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//Check Welcome text"Section Heading"
	@FindBy(how=How.XPATH, using= ".//div//h2[@class='text-center']")
	public WebElement Verifytext;
	//List all the products Section
	@FindBy(how=How.CLASS_NAME, using="item-cart-group")
	public List<WebElement> CartProducts;
	//List all the products in the cart
	@FindBy(how=How.XPATH, using = ".//div[@class='item-cart-group']//div//a//img")
	public List<WebElement> ProductImagePath;
	//List all the Product titles
	@FindBy(how=How.XPATH, using = ".//div[@class='item-cart-group']//h3[@class='item-title']")
	public List<WebElement> ProductTitle;
	//List all the product subtitles
	@FindBy(how=How.XPATH, using = ".//div[@class='select-variant']//h4[@class='item-subtitle']")
	public List<WebElement> ProductSubTitle;
	//List all the Product's quantity
	@FindBy(how=How.XPATH, using =".//span[@class='quantity-value']")
	public List<WebElement> ProductQuantity;
	//List all Product's Subscription Types
	@FindBy(how=How.XPATH, using=".//div[@class='item-cart-group']//input[@class='input-radio-custom']")
	public List<WebElement> SubscriptionStatus;
	//List selected subscription types for all products
	@FindBy(how=How.XPATH, using=".//div[@class='item-cart-group']//option[@selected='selected']")
	public List<WebElement> SubscriptionSelected;
	//List all the Product Prices
	@FindBy(how=How.CLASS_NAME, using="item-price")
	public List<WebElement> ProductTotalPrice;
	//List close button element for each product section
	@FindBy(how=How.CLASS_NAME, using="close-button")
	public List<WebElement> CloseButton;
	//Title of the main billing area
	@FindBy(how=How.XPATH, using=".//div[@class='cart-summary']//h3[@class='text-center']")
	public WebElement CartSummaryTitle;
	//Element locating subscription label
	@FindBy(how=How.ID, using="summary_discount_subscription")
	public WebElement SummaryDiscountSub;
	//Element locating Subscription Discount amount
	@FindBy(how=How.ID, using="summary_subscription_price")
	public WebElement SummarySubDiscount;
	//Element locating Discount Code Label Value
	@FindBy(how=How.XPATH, using=".//div[@id='summary_discount_code']//span[@id='summary_discount_code_value']")
	public WebElement SummaryDiscountCodeValue;
	//Element locating Discount Code Price
	@FindBy(how=How.XPATH, using=".//div[@id='summary_discount_code']//span[@id='summary_discount_code_price']")
	public WebElement SummaryDiscountCodePrice;
	//Element Locating MyCredit Label
	@FindBy(how=How.XPATH, using=".//div[@id='summary_mycredit']/span[1]")
	public WebElement MyCreditLabel;
	//Element Locating MyCredit Price
	@FindBy(how=How.ID, using="summary_mycredit_price")
	public WebElement MyCreditPrice;
	//Element locating Gift card slab
	@FindBy(how=How.XPATH, using=".//ul[@id='giftcard-list']")
	public WebElement GiftCard;
	//Element locating Sub total label
	@FindBy(how=How.XPATH, using=".//div[@id='summary_subtotal']//span[1]")
	public WebElement TotalLabel;
	//Element locating Total Price
	@FindBy(how=How.ID, using="subtotal_price")
	public WebElement TotalPrice;
	// Element locating promo code input field
	@FindBy(how=How.ID, using="discount_code")
	public WebElement EntrPromoCode;
	//Element locating Apply button for Promo code submit
	@FindBy(how=How.ID, using="discountapply")
	public WebElement ClickToApplyPC;
	//Element location discount add message for promo code
	@FindBy(how=How.ID, using="discount_message")
	public WebElement DiscountMessage;
	//Element locating input field to enter Gift card
	@FindBy(how=How.ID, using="giftcard_code")
	public WebElement EntrGiftCardCode;
	//Element locating button to apply gift card
	@FindBy(how=How.ID, using="giftcardapply")
	public WebElement ClickToApplyGC;
	//Element locating Gift Card Message
	@FindBy(how=How.ID, using="giftcard_message")
	public WebElement GiftCardMessage;
	//Element locating Main checkout button
	@FindBy(how=How.ID, using="checkout-btn")
	public WebElement CheckoutBtn;
	
	
	public void VerifyProductList(String VerifyText)
	{
		//Code verifying Product List details
		
			wait = new WebDriverWait(driver, 5);
			WriteOutputData WOD = new WriteOutputData();
			
			wait.until(ExpectedConditions.visibilityOf(Verifytext));
			
			System.out.println(Verifytext.getText());
		
			if(Verifytext.getText().contains(VerifyText))
			{
				try {
					WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 11, 3, "Pass");
					WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 11, 2, Verifytext.getText());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Cart Page" + e.getMessage());
				}
				for (int i=0;i<CartProducts.size();i++)
				{
					System.out.println("*************Products List " + i + ".*************");
					
					System.out.println("Product Image: " + ProductImagePath.get(i).getAttribute("src"));
					System.out.println("Product Name: " + ProductTitle.get(i).getText());
					System.out.println("Product Subtitle: " + ProductSubTitle.get(i).getText());
					System.out.println("Product selected Quantity: " + ProductQuantity.get(i).getText());
					
						if(SubscriptionStatus.get(i).isSelected())
						{
							System.out.println("Subscription Type Selected: " + SubscriptionSelected.get(i).getText());
						}
					
					System.out.println("Product price: " + ProductTotalPrice.get(i).getText());
										
				}
			}
			else {
				try {
					WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 11, 3, "Fail");
					WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 11, 2, Verifytext.getText());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Cart Page" + e.getMessage());
				}
			}
	}
	
	public void VerifyOrderSummary()
	{
		//Code verifying Order Summary
		System.out.println("***************" + CartSummaryTitle.getText() + "***************");
		System.out.println(SummaryDiscountSub.getText() + " : " + SummarySubDiscount.getText());
		System.out.println(SummaryDiscountCodeValue.getText() + " : " + SummaryDiscountCodePrice.getText());
		System.out.println(MyCreditLabel.getText() + " : " + MyCreditPrice.getText());
			if(GiftCard.getText().isEmpty())
			{
				System.out.println("Gift Card not available");
			}
			else
			{
				System.out.println("Gift Card : " + GiftCard.getText());
			}
			
		System.out.println(TotalLabel.getText() + " : " + TotalPrice.getText());
		
		
	}
	
	public void VerifyDiscoutCards()
	{
		//Code verifying Promo and Gift card flow
		EntrPromoCode.sendKeys("");
		ClickToApplyPC.click();
		System.out.println("Response for Promo Applied : " + DiscountMessage.getText());
		
		EntrGiftCardCode.sendKeys("");
		ClickToApplyGC.click();
		System.out.println("Response to Gift Card: " + GiftCardMessage.getText());
		
		
		
	}
	
	public void Checkout()
	{
		//Code Initiating Checkout Flow
		CheckoutBtn.click();
	}
}
