package testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		driver.findElement(By.linkText("Instagram")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		System.out.println(it.next());//parentwindow id
		String secondWindow = it.next();
		driver.switchTo().window(secondWindow);
		driver.findElement(By.xpath("//*[text()='Locations']")).click();
		driver.quit();
		

	}

}
