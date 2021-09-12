package reusablecomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import utility.PropertyFileReader;

public class Reusablecomponent {

	public static WebDriver driver;
	

	public static WebDriver initializedriver() throws IOException {
		// TODO Auto-generated method stub
		
		String Bname=PropertyFileReader.loadFile().getProperty("browser");
		
		if(Bname.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",PropertyFileReader.loadFile().getProperty("ChromeDriverPath"));
			ChromeOptions opt =new ChromeOptions();
			opt.addArguments("--disable-notifications");
			driver=new ChromeDriver(opt);
		}
		else if(Bname.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe");
			driver=new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public static void captureScreen(String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(PropertyFileReader.loadFile().getProperty("screenshot")+ "/Screenshots/" + tname + ".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Screenshot taken");
	}
}
