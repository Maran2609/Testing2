package pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import reusablecomponents.ReusableMethods;
import uistore.LandingpageUI;

public class Landingpage {

	public static boolean place(WebDriver driver,String origin,String arrival ) throws InterruptedException
	{
		if(ReusableMethods.click(LandingpageUI.origin, driver))
		{
			Thread.sleep(2000L);
		if(ReusableMethods.sendKeys(LandingpageUI.origin, origin, driver))
		{
			Thread.sleep(2000L);
			if(ReusableMethods.getElement(LandingpageUI.origin, driver))
			{
				Thread.sleep(2000L);
				if(ReusableMethods.sendKeys(LandingpageUI.arrival, arrival, driver))
				{
					Thread.sleep(2000L);
					if(ReusableMethods.getElement(LandingpageUI.arrival, driver))
					{
						return true;
						
					}
				}
			}
					
		}
		}
		return false;
	}
		public static boolean Date(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(2000);
			 if(ReusableMethods.click(LandingpageUI.calender, driver))
			 {
				 Thread.sleep(2000);
				 if(ReusableMethods.click(LandingpageUI.date, driver))
				 {
					  String values=driver.findElement(LandingpageUI.datetext).getText();
					 System.out.println(values);
					 Assert.assertEquals(values, "16 Sep' 21");
			              return true;
					 }
				 }
			 return false;		
		}
		public static boolean search_flights_button(WebDriver driver)
		{
			if(ReusableMethods.click(LandingpageUI.search_button, driver))
			{			
				return true;
			 }
			return false;
		}
}
