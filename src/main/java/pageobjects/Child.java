package pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import reusablecomponents.ReusableMethods;
import uistore.OfferUI;

public class Child {
	public static boolean verifies(WebDriver driver)
	{
	  if(ReusableMethods.click(OfferUI.ver, driver))
	  {
		return true;
	  }
	  return false;
	}
	
	public static boolean child(WebDriver driver,String name)
	{
	  Set<String> wind =driver.getWindowHandles();
	  Iterator<String> it=wind.iterator();
	  String parent=it.next();
	  String child=it.next();
	  driver.switchTo().window(child);
	  String title=driver.getTitle();
	  Assert.assertEquals(title,name);
	  System.out.println("Title valid successfully");
	  driver.switchTo().window(parent);
	  return true;
	}

}
