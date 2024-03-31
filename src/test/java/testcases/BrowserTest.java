package testcases;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//CTRL+SHIFT+O
public class BrowserTest {

	public static void main(String[] args) {
		String browser = "edge";
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		
		else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} 
		
		else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();//Method chaining
		/*
		 * Options m = driver.manage(); Window window = m.window(); window.maximize();
		 */
		driver.get("https://google.com");
		String actualTitle=driver.getTitle();
		String expectedTitle = "Google";
		
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("TC is passed");
		}
		else {
			System.out.println("TC is failed");
		}
		driver.close();

	}

}
