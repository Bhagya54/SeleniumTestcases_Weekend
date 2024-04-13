package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropBy_2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
		WebElement source = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(source, 200, 300).perform();
			
	}

}
