package org.UIInterface;

import java.util.Iterator;
import java.util.List;

import org.excelmethods.WriteOutputData;
import org.interfaces.SearchResultPageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultPage implements SearchResultPageInterface{

	WebDriver driver;
	//HomePage hpobj = new HomePage(driver);
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='newsletter_sign_up']/button") //Get Newsletter cross button
	public WebElement Closenewsletter;
	
	
	@FindBy(how=How.CSS,using=".large-9.columns>h3>a")  // Get Search results title
	public List<WebElement> searchresults;
	
	
	public void getresults(String SearchText)
	{
				
		Closenewsletter.click();
		WriteOutputData WOD = new WriteOutputData();
		
		Iterator<WebElement> itr = searchresults.iterator();
		System.out.println("****************Products listed in Search result***********************");
		while(itr.hasNext())
				{
					String ResultVal = itr.next().getText();
					
					System.out.println(ResultVal);
					
					
					if(ResultVal.contains(SearchText))
					{
						System.out.println("********Product Match Found**********");
						driver.findElement(By.linkText(ResultVal)).click();
						try {
							WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 7, 3, "Pass");
							WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 7, 2, ResultVal);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("Search page" + e.getMessage());
						}
						break;
					}
					else{
						try {
							WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 7, 3, "Fail");
							WOD.WriteData("D:\\Ankush Data\\drive\\recover_1\\selenium\\data\\TBData.xlsx", 0, 7, 2, "Search Text Not Found");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("Search page" + e.getMessage());
						}
					}
				}
		
		
	}
	
	
	
}
