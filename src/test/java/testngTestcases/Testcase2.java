package testngTestcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testcase2 {

	@Test
	public void verifyTitle() {
		String expectedTitle = "google";
		String actualTitle = "gmail";
		
		Assert.assertEquals(actualTitle, expectedTitle,"Title is not matching");
	}
	//assertTrue(condition)//true and false
	//assertFalse(true)// pass and fail
	@Test
	public void assertTrueCond() {
		
		int a=20;
		int b=10;
		String expectedTitle = "google";
		String actualTitle = "gmail";
		
		Assert.assertEquals(actualTitle, expectedTitle,"Title is not matching");//hard assert
		Assert.assertTrue(a==b,"a and b values are not same");
		
		
	}
	
	@Test
	public void assertFalseCond() {
		
		int a=10;
		int b=20;
		Assert.assertFalse(a==b,"a and b values are same");
	}
	
	@Test
	public void intentionallyFail() {
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
		
		soft.assertEquals(actualTitle, expectedTitle,"Title is not matching");//hard assert
		soft.assertTrue(a==b,"a and b values are not same");
		
		soft.assertAll();
	}
	
}
