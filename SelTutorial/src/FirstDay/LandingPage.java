package FirstDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LandingPage {

	static WebDriver driver;
	static String path = "http://landing.driverrestore.com/en/v1/index.jsp";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   
	    
	    
	    for (int i=0;i<30;i++)
	    {
	    	System.setProperty("webdriver.ie.driver", "./extrafiles/IEDriverServer.exe");
			
	    	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	    	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	    	
		    driver = new InternetExplorerDriver();
		    
		    driver.manage().window().maximize();
		    
		    driver.manage().deleteAllCookies();
		    
		    
	    	//driver.get(path);
	    	driver.navigate().to(path);
	    	
	    	/*try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		    
		    String PageSource = driver.getPageSource();
		    
		    //System.out.println(PageSource);
		    
		    if (PageSource.contains("dr2.8.5.3"))
		    {
		    	System.out.println("*************New Path Found**************");
		    	break;
		    }
		    else {
		    	System.out.println("Not Found Try Count : " + i);
		    	
		    }
		    driver.close();
		    
	    }
	    

	}

}
