package reusablecomponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utility.PropertyFileReader;



public class ReusableMethods {

	public static void loadURL(WebDriver driver) {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		timelapse(driver);
	}
	
	public static void timelapse(WebDriver driver) {
		int wait = Integer.parseInt(PropertyFileReader.loadFile().getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}
	
	public static boolean getElement(By selector, WebDriver driver) {
		try {
			driver.findElement(selector).sendKeys(Keys.ENTER);;
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Element %s doesnt exist", selector));
		}
		return false;
	}
	
	public static boolean sendKeys(By selector, String keys, WebDriver driver) {
		try {
			driver.findElement(selector).sendKeys(keys);;
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Keys could not be sent to Element %s ", selector));
		}
		return false;
	}
	
	
	public static boolean click(By selector, WebDriver driver) {
		try {
			driver.findElement(selector).click();;
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Element %s could not be clicked ", selector));
		}
		return false;
	}
}
