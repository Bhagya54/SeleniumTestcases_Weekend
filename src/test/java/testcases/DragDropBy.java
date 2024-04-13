package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropBy {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		WebElement sl = driver.findElement(By.id("slider"));
		int width=sl.getSize().getWidth();
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider,width/2,0).dragAndDropBy(slider,-width/4,0).build().perform();
		
	}

}
