package FirstDay;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstLesson {

	@Test(priority=3,description="First method with priority 3")
	public void First()
	{
		System.out.println("Hello First");
	}
	
	@Test(priority=2,description="Second method with priority 2")
	public void Third()
	{
		System.out.println("Hello Third");
	}
	
	@Test(priority=1,description="Third method with priority 1")
	public void Second()
	{
		System.out.println("Hello Second");
		Assert.assertEquals(10, 20);
	}
	
}
