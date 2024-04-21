package testngTestcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testcase1 {
	

	@BeforeClass
	public void openDBConnection() {
		System.out.println("Open DB connection");
	}

	@AfterClass
	public void CloseDBConnection() {
		System.out.println("Close DB connection");
	}

	
	@BeforeMethod
	public void setUp() {
		System.out.println("Launching Browser");
	}

	
	@AfterMethod
	public void tearDown() {
		System.out.println("close the browser");
	}

	@Test(priority= 16,groups = {"regression","sanity"})
	public void userReg() {
		System.out.println("User Reg");
		
	}

	@Test(priority=47,dependsOnMethods = {"userReg"},groups = "sanity")
	public void login() {
		System.out.println("Login");
		Reporter.log("Login Test");
	}

}
