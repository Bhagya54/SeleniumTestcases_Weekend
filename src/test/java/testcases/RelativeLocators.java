package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators {
/*toLeftOf
 * toRightOf
 * below
 * above
 * near
 * 
 * 
 */
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		WebElement username = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.name("pass")));
		username.sendKeys("dgfhjasgf");
		
		WebElement password = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.name("email")));
		password.sendKeys("dgfsfgghgh");
	}

}
