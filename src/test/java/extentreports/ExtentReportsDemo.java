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

public class ExtentReportsDemo {

	public ExtentSparkReporter htmlReporter; // generate a html file
	public ExtentReports extent;// configuration
	public ExtentTest test;// testcase status -- pass/fail/skipped

	@BeforeTest
	public void setUp() {
		htmlReporter = new ExtentSparkReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("learning extent reports");
		htmlReporter.config().setReportName("Automation Testing");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("buildName", "45F");
		extent.setSystemInfo("testname","bhagya");
		extent.setSystemInfo("company","abc");
			
	}
	
	@AfterTest
	public void tearDown() {
		extent.flush();
	}
	
	@Test
	public void doLogin() {
		test=extent.createTest("Login Test");
		test.info("Entered username");
		test.info("Entered password");
		test.info("Clicked on login");
		
	}
	
	@Test
	public void doUserReg() {
		test=extent.createTest("User Reg Test");
		Assert.fail("Intentionally failing");
		
	}
	
	@Test
	public void doSkip() {
		test=extent.createTest("Skip Test");
		throw new SkipException("Intentionally skipping");
		
	}
	
	@AfterMethod
	public void getStatus(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Markup m;
		if(result.getStatus()==ITestResult.SUCCESS) {
			m=MarkupHelper.createLabel("Test case Passed: " + methodName, ExtentColor.GREEN);
			test.pass(m);
		}
		
		else if(result.getStatus()==ITestResult.FAILURE) {
			m=MarkupHelper.createLabel("Test case Failed: " + methodName, ExtentColor.RED);
			test.fail(m);
		}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			m=MarkupHelper.createLabel("Test case Skipped: " + methodName, ExtentColor.AMBER);
			test.skip(m);
		}
		
	}
	
	
}
