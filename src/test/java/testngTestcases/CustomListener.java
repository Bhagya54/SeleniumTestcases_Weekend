package testngTestcases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListener implements ITestListener {

	public void onTestStart(ITestResult result) {

		Reporter.log("Test has been started: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test has been passed: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Test has been failed: " + result.getName());
		Reporter.log("<a href=\"C:\\Users\\Bhagya_Kudupudi\\Desktop\\download.png\" target=\"_blank\">screenshot</a>");
		Reporter.log("<a href=\"C:\\Users\\Bhagya_Kudupudi\\Desktop\\download.png\" target=\"_blank\"><img src=\"C:\\Users\\Bhagya_Kudupudi\\Desktop\\download.png\" height=200 width=200</a>");
	}

	public void onFinish(ITestContext context) {
		Reporter.log("Test has been finished: "+ context.getName());
	}

}
