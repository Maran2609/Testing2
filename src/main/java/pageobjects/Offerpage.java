package pageobjects;

import org.openqa.selenium.WebDriver;

import reusablecomponents.ReusableMethods;
import uistore.OfferUI;

public class Offerpage {
	public static boolean click_offers(WebDriver driver)
	{
		if(ReusableMethods.click(OfferUI.offerclick,driver))
		{
			return true;
		}
		return false;
	}
	
	public static boolean highlighted(WebDriver driver)
	{
		if(driver.findElement(OfferUI.display).isDisplayed())
		{
			return true;
		}
		return false;
	}	

}
