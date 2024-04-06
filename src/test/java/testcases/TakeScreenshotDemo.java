package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshotDemo {
	
	static WebDriver driver;
	public static void takeScreenshot() throws IOException {
		Date d = new Date();
		String fileName=d.toString().replace(" ","_").replace(":","_")+".jpg";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/"+fileName));
	}

	public static void takeElementScreenshot(WebElement ele) throws IOException {
		Date d = new Date();
		String fileName="ele_" +d.toString().replace(" ","_").replace(":","_")+".jpg";
		File src = ele.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/"+fileName));
	}
	public static void main(String[] args) throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		
		takeScreenshot();
		
		
		driver.switchTo().frame("iframeResult");
		
		WebElement submit = driver.findElement(By.id("mySubmit"));
		
		takeElementScreenshot(submit);
		driver.findElement(By.xpath("/html/body/button")).click();
				
		  driver.switchTo().defaultContent();
		  driver.findElement(By.id("tryhome")).click();
		  takeScreenshot();
		
		 
	}

}
