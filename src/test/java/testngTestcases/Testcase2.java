package testngTestcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testcase2 {

	@Test(groups = {"smoke","regression"})
	public void verifyTitle() {
		String expectedTitle = "google";
		String actualTitle = "gmail";
		
		AssertJUnit.assertEquals(actualTitle, expectedTitle,"Title is not matching");
	}
	//assertTrue(condition)//true and false
	//assertFalse(true)// pass and fail
	@Test(groups = "smoke")
	public void assertTrueCond() {
		
		int a=20;
		int b=10;
		String expectedTitle = "google";
		String actualTitle = "gmail";
		Reporter.log("Verifying titles");
		Assert.assertEquals(actualTitle, expectedTitle,"Title is not matching");//hard assert
		Assert.assertTrue(a==b,"a and b values are not same");
		
		
	}
	
	@Test(groups = "regression",enabled = false)
	public void assertFalseCond() {
		
		int a=10;
		int b=20;
		Reporter.log("Verifying 2 integer values");
		Assert.assertFalse(a==b,"a and b values are same");
	}
	
	@Test
	public void intentionallyFail() {
		Reporter.log("Intentionally Failing Test");
		Assert.fail("Intentionally failed");
	}
	
	@Test
	public void intentionallySkip() {
		throw new SkipException("Intentionally Skip a testcase");
	}
	
	@Test
	public void softAssertCond() {
		SoftAssert soft = new SoftAssert();
		int a=20;
		int b=10;
		String expectedTitle = "google";
		String actualTitle = "gmail";
		
		Assert.assertEquals(actualTitle, expectedTitle,"Title is not matching");//hard assert
		Assert.assertTrue(a==b,"a and b values are not same");
		
		soft.assertAll();
	}
	
}
