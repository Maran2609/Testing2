package runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Child;
import pageobjects.Landingpage;
import pageobjects.Offerpage;
import reusablecomponents.Reusablecomponent;
import utility.ExcelReader;
import utility.PropertyFileReader;

public class Tests extends Reusablecomponent{
	
	
	@BeforeClass
	public void driverlaunch() throws IOException
	{
		Reusablecomponent.initializedriver();
		
	}
	@Test(dataProvider = "getTestData",priority=1)
	public void searchflight(String origin,String arrival) throws InterruptedException
	{
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		Landingpage.place(driver,origin,arrival);
		Landingpage.Date(driver);
		Landingpage.search_flights_button(driver);
		
	}
	@Test(priority=2)
	public void Verify()
	{
		Offerpage.click_offers(driver);
		Offerpage.highlighted(driver);
	}
	@Test(priority=3)
	public void title()
	{
		Child.verifies(driver);
		Child.child(driver, "Travelguru: Book Homestays, Vacation Rentals, Hotels & More");
	}

	@BeforeTest
	@DataProvider(name="getTestData")
	public Object[][] getTestData() {
		Object[][]data = null;
		try {
			data= ExcelReader.getdata("Sheet1");			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}