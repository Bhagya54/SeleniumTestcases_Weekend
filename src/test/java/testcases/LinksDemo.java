package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/footer/nav"));

		List<WebElement> links = block.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getAttribute("href"));
		}
	}

}
