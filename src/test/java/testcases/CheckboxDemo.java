package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckboxDemo {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		WebElement block = driver.findElement(By.xpath("(//div[@class='display'])[1]"));
		List<WebElement> sports = block.findElements(By.name("sports"));
		
		for(int i=0;i<sports.size();i++) {
			sports.get(i).click();
		}

	}

}
