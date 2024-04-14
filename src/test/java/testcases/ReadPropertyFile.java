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

public class ReadPropertyFile {

	static WebDriver driver;
	static FileInputStream fis;
	static Properties or;
	static Properties config;
	static Logger log = Logger.getLogger(ReadPropertyFile.class);

	public static void main(String[] args) throws IOException {
		fis = new FileInputStream("./src/test/resources/properties/log4j.properties");
		PropertyConfigurator.configure(fis);
		
		config = new Properties();
		fis = new FileInputStream("./src/test/resources/properties/Config.properties");
		config.load(fis);
		log.info("Config file has been loaded");

		or = new Properties();
		fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		or.load(fis);
		log.info("OR file has been loaded");

		if (config.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
			log.info("Chrome browser launched");
		}

		else if (config.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
			log.info("Firefox browser launched");
		}

		else if (config.getProperty("browser").equals("edge")) {
			driver = new EdgeDriver();
			log.info("Edge browser launched");
		}

		driver.manage().window().maximize();
		log.info("Maximized the browser window");
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigate to url: " +config.getProperty("testsiteurl"));
		System.out.println(config.getProperty("browser"));

		// driver.findElement(By.id(or.getProperty("username_ID"))).sendKeys("svdsadysa");
		// driver.findElement(By.name(or.getProperty("pswd_NAME"))).sendKeys("svdsadysa");
		// driver.findElement(By.xpath(or.getProperty("loginbtn_XPATH"))).click();
		type("username_ID", "svdsadysa");
		type("pswd_NAME", "svdsadysa");
		click("loginbtn_XPATH");
	}

	//keyword driven
	public static void type(String keyword, String value) {
		if (keyword.endsWith("_ID")) {
			driver.findElement(By.id(or.getProperty(keyword))).sendKeys(value);
		} else if (keyword.endsWith("_NAME")) {
			driver.findElement(By.name(or.getProperty(keyword))).sendKeys(value);
		} else if (keyword.endsWith("_XPATH")) {
			driver.findElement(By.xpath(or.getProperty(keyword))).sendKeys(value);
		} else if (keyword.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(keyword))).sendKeys(value);
		}
		log.info("Typed on keyword: " + keyword + " and entered value: " +value);
	}

	public static void click(String keyword) {
		if (keyword.endsWith("_ID")) {
			driver.findElement(By.id(or.getProperty(keyword))).click();
			;
		} else if (keyword.endsWith("_NAME")) {
			driver.findElement(By.name(or.getProperty(keyword))).click();
		} else if (keyword.endsWith("_XPATH")) {
			driver.findElement(By.xpath(or.getProperty(keyword))).click();
		} else if (keyword.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(keyword))).click();
		}
		log.info("Clicked on keyword: " + keyword);
	}

}
