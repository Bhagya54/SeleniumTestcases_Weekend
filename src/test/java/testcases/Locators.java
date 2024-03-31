package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://gmail.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//dynamic
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement username =driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
		username.sendKeys("java@way2automation.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		//Thread.sleep(5000);//manual way
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"))).sendKeys("dfdsfdsf");
		driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("sghdgasjd");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
		
		System.out.println(driver.findElement(By.xpath("(//div[@jsname='B34EJ'])[1]/span")).getText());
	}

}
