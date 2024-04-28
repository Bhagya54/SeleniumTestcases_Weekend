package testngTestcases;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParamaterizationUsingXML {

	WebDriver driver;
	@Parameters({ "browser" ,"siteurl"})
	@BeforeClass

	public void lauchBrowser(String browserName,String url) {
		Date d = new Date();
		System.out.println(browserName + " " + url + " " + d.toString());
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.get(url);
	}
}
