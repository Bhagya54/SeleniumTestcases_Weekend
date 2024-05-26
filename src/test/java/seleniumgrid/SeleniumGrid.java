package seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGrid {

	RemoteWebDriver driver;
	Capabilities cap;
	@Parameters({ "browser" ,"siteurl"})
	@Test

	public void lauchBrowser(String browserName,String url) throws MalformedURLException {
		Date d = new Date();
		System.out.println(browserName + " " + url + " " + d.toString());
		if(browserName.equalsIgnoreCase("Chrome")) {
			cap = new ChromeOptions();
			
		}
		
		else if(browserName.equalsIgnoreCase("Firefox")) {
			cap = new FirefoxOptions();
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("q")).sendKeys("Hello browser: " + browserName+ "selenium webdriver");
		new Actions(driver).sendKeys(Keys.ENTER).perform();
	}
}
