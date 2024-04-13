package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToEle {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.carwale.com/");
		WebElement newcar = driver.findElement(By.xpath("//*[text()='NEW CARS']"));
		Actions act = new Actions(driver);
		act.moveToElement(newcar).perform();
		driver.findElement(By.xpath("//*[text()='Find New Cars']")).click();
	}

}
