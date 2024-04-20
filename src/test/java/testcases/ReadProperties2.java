package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadProperties2 {
	static WebDriver driver;
	static FileInputStream fis;
	static Properties config1;
	static Properties or1;
	static Logger log = Logger.getLogger(ReadProperties2.class);

	public static void main(String[] args) throws IOException {
		fis = new FileInputStream("./src/test/resources/Properties/log4j.properties");
		PropertyConfigurator.configure(fis);

		config1 = new Properties();
		fis = new FileInputStream("./src/test/resources/Properties/Config.properties");
		config1.load(fis);
		log.info("Config1 file has loaded");

		or1 = new Properties();
		fis = new FileInputStream("./src/test/resources/Properties/OR.properties");
		or1.load(fis);
		log.info("OR1 file has loaded");

		if (config1.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
			log.info("Chrome browser has launched");
		} else if (config1.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
			log.info("Firefox browser has launched");
		} else if (config1.getProperty("browser").equals("edge")) {
			driver = new EdgeDriver();
			log.info("Edge browser has launched");
		}
		driver.manage().window().maximize();
		log.info("browser is maximized");
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config1.getProperty("implicit.wait"))));
		driver.get(config1.getProperty("URL"));

		type("Username_XPATH","gffddty34");
		type("Password_XPATH","twtqyu4536");
		click("Loginbtn_XPATH");
	}

	public static void type(String keyword, String value) {
		if (keyword.endsWith("_ID")) {
			driver.findElement(By.id(or1.getProperty(keyword))).sendKeys(value);
		} else if (keyword.endsWith("_NAME")) {
			driver.findElement(By.name(or1.getProperty(keyword))).sendKeys(value);
		} else if (keyword.endsWith("_XPATH")) {
			driver.findElement(By.xpath(or1.getProperty(keyword))).sendKeys(value);
		} else if (keyword.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(or1.getProperty(keyword))).sendKeys(value);
		}
		log.info("Typed:" + keyword + "and" + "Entered:" + value);
	}

	public static void click(String keyword) {
		if (keyword.endsWith("_ID")) {
			driver.findElement(By.id(or1.getProperty(keyword))).click();
	}
		else if (keyword.endsWith("_NAME")) {
			driver.findElement(By.name(or1.getProperty(keyword))).click();
	}
		else if (keyword.endsWith("_XPATH")) {
			driver.findElement(By.xpath(or1.getProperty(keyword))).click();
	}
		else if (keyword.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(or1.getProperty(keyword))).click();
	}
		log.info("Clicked:"+keyword);
}
}