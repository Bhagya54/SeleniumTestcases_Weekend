package extentreports;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import extentlisteners.ExtentListeners;

public class ExtentTestCases {

	
	
	@Test
	public void doLogin() {
		
		ExtentListeners.test.info("Entered username");
		ExtentListeners.test.info("Entered password");
		ExtentListeners.test.info("Clicked on login");
		
	}
	
	@Test
	public void doUserReg() {
		ExtentListeners.test.info("User Reg test");
		Assert.fail("Intentionally failing");
		
	}
	
	@Test
	public void doSkip() {
		ExtentListeners.test.info("Skip Test");
		throw new SkipException("Intentionally skipping");
		
	}
	
	
	
	
}
