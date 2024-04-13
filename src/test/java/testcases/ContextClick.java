package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://deluxe-menu.com/popup-mode-sample.html");
		WebElement source = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));
		Actions act = new Actions(driver);
		act.contextClick(source).perform();
		driver.findElement(By.id("dm2m1i1tdT")).click();
		driver.findElement(By.xpath("//*[@id=\"dm2m2i1tdT\"]")).click();
		driver.findElement(By.id("dm2m3i1tdT")).click();
		
			
	}

}
