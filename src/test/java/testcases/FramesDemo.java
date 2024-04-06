package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int noOfFrames = frames.size();
		for(int i=0;i<noOfFrames;i++) {
			System.out.println(frames.get(i).getAttribute("id"));
		}
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("tryhome")).click();
	}

}
