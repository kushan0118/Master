package org.UIInterface;

/**
 * @author Ankush
 *
 */


import java.util.List;

import org.excelmethods.WriteOutputData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderReviewPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public OrderReviewPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locating H2 heading text element
	@FindBy(how=How.XPATH, using=".//div[@class='main__content']//h2")
	public WebElement VerifyText;
	//locating shipping Name element
	@FindBy(how=How.ID, using="shipping_name")
	public WebElement ShippingName;
	//locating shipping Total Amount element
	@FindBy(how=How.ID, using="shipping_ftotal")
	public WebElement ShippingTotalAmt;
	//locating shipping address element
	@FindBy(how=How.ID, using="shipping_to")
	public WebElement ShippingAddress;
	//locating summary label values
	@FindBy(how=How.XPATH, using=".//div[@class='accordionContent']//span[@class='float-left']")
	public List<WebElement> OrderSummarylabels;
	//locating summary label amount
	@FindBy(how=How.XPATH, using=".//div[@class='accordionContent']//span[@class='float-right']")
	public List<WebElement> OrderSummaryAmt;
	//locating My Credit and discount value separately
	@FindBy(how=How.ID, using="my_credit")
	public WebElement CreditVal;
	@FindBy(how=How.ID, using="discount_value")
	public WebElement DiscountVal;
	//locating 'Place Order' button and click
	@FindBy(how=How.ID, using="pobtn")
	public WebElement PlaceOrder;
	//Locating Image and details element
	@FindBy(how=How.XPATH, using=".//*[@class='img-wrapper']//img")
	public List<WebElement> ImgWrap;
	//locating Item Title element
	@FindBy(how=How.CLASS_NAME, using="item-title ")
	public List<WebElement> ItemTitle;
	//locating Item Detail element
	@FindBy(how=How.CLASS_NAME, using="item-product-details")
	public List<WebElement> ItemDetail;
	//locating item price element
	@FindBy(how=How.CLASS_NAME, using=" item-price")
	public List<WebElement> ItemPrice;
	//locating element for Bill to Name
	@FindBy(how=How.ID, using="bill-to")
	public WebElement BillToName;
	//locating last two number element
	@FindBy(how=How.ID, using="lasttwo")
	public WebElement CCNum;
	
	public void VerifyText(String Expected)
	{
		//Verify text for element and page load
		/*wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(VerifyText));*/
		WriteOutputData WOD = new WriteOutputData();
		if (VerifyText.getText().contains(Expected))
		{
			System.out.println("************Review Page*************");
			try {
				WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 13, 3, "Pass");
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Review Page" + e.getMessage());
			}
		}
		else{
			System.out.println("Text is different from expected" + VerifyText.getText());
		}
	}
	
	public void VerifyDetail()
	{
		//Verify details from other pages
	}
	
	public void PlaceOrder()
	{
		//Place Order and continue
		System.out.println("Name of Shipment : " + ShippingName.getText());
		System.out.println();
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(ShippingTotalAmt));
		System.out.println("Total Shipment Amount : " + ShippingTotalAmt.getText());
		System.out.println();
		System.out.println("Shipping Address : " + ShippingAddress.getText());
		System.out.println();
		
		int count = 1;
			
			for(int i=0;i<OrderSummarylabels.size();i++)
			{
				WebElement LabelText = OrderSummarylabels.get(i);
				WebElement LabelAmt;
				String Value;
				
					if(LabelText.getText().equalsIgnoreCase("My Credit"))
					{
						Value = CreditVal.getText();
						
					}
					else if (LabelText.getText().equalsIgnoreCase("Discount")) {
						Value = DiscountVal.getText();
					}
					else if(i>=2){
						LabelAmt = OrderSummaryAmt.get(count);
						Value = LabelAmt.getText();
						count = count +1;
					}
					else {
						Value = OrderSummaryAmt.get(i).getText();
					}
				
				
					System.out.println(LabelText.getText() + " : " + Value);
			}
			
			for(int i=0;i<ImgWrap.size();i++)
			{
				WebElement ItemDetail = ImgWrap.get(i);
					String ItemImage = ItemDetail.getAttribute("src");
					String ItemSpec = ItemDetail.getAttribute("alt");
					
					System.out.println("Product Image : " + ItemImage);
					System.out.println("Product Specifications : " + ItemSpec);
					System.out.println("Product Price : " + ItemPrice.get(i).getText());
			}
			//payment details
			System.out.println("Bill To : " + BillToName.getText());
			System.out.println("Last two Card Numbers : " + CCNum.getText());
		
		PlaceOrder.click();
	}
	
}
