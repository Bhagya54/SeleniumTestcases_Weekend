package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutor {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		
		driver.switchTo().frame("iframeResult");
		((JavascriptExecutor) driver).executeScript("myFunction()");
		WebElement submit = driver.findElement(By.id("mySubmit"));
		WebElement tryIT = driver.findElement(By.xpath("/html/body/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", submit);
		driver.findElement(By.xpath("/html/body/button")).click();
		
		
		  driver.switchTo().defaultContent();
		  driver.findElement(By.id("tryhome")).click();
		 
	}

}
