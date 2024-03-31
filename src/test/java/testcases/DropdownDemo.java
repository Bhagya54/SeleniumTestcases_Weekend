package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownDemo {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		Select languages = new Select(dropdown);
		List<WebElement> lang = driver.findElements(By.tagName("option"));
		System.out.println(lang.size());
		for(int i=0;i<lang.size();i++) {
			System.out.println(lang.get(i).getAttribute("lang"));
		}

	}

}
