package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v122.security.Security;

public class CDP_SSLCert {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Security.enable());
		devtools.send(Security.setIgnoreCertificateErrors(true));
		driver.get("https://expired.badssl.com/");

	}

}
