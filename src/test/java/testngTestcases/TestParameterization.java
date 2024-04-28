package testngTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelReader;
import utility.TestBase;

public class TestParameterization extends TestBase {
	
	@Test(dataProvider = "dp")
	public void doLogin(String username, String password) {
		type("username_ID",username);
		type("pswd_NAME",password);
		click("loginbtn_XPATH");

	}

	@DataProvider(name = "dp")
	public Object[][] getData() {
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
		String sheetName = "login";

		int rowCount = excel.getRowCount(sheetName);// 4
		int colCount = excel.getColumnCount(sheetName);// 2

		System.out.println("Row Count: " + rowCount + " column count: " + colCount);

		Object[][] data = new Object[rowCount - 1][2];
		// row = 4<=4,col = 1<2
		for (int row = 2; row <= rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				data[row - 2][col] = excel.getCellData(sheetName, col, row);
			}
		}
		/*
		 * data[0][0] = excel.getCellData(sheetName, 0,2); data[0][1] =
		 * excel.getCellData(sheetName, 1,2);
		 * 
		 * data[1][0] = excel.getCellData(sheetName, 0,3); data[1][1] =
		 * excel.getCellData(sheetName, 1,3);
		 * 
		 * data[2][0] = excel.getCellData(sheetName, 0,4); data[2][1] =
		 * excel.getCellData(sheetName, 1,4);
		 */
		/*
		 * data[0][0] = "testing1"; data[0][1] = "password1";
		 * 
		 * data[1][0] = "testing2"; data[1][1] = "password2";
		 * 
		 * data[2][0] = "testing3"; data[2][1] = "password3";
		 */

		return data;
	}
}
