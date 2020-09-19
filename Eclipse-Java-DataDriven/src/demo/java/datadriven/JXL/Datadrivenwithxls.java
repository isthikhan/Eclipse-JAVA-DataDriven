package demo.java.datadriven.JXL;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Datadrivenwithxls {
	String[][] data = null;
	WebDriver driver;

	@DataProvider(name = "logindata")
	public String[][] logindataprovider() throws BiffException, IOException {
		data = exceldata();
		return data;

	}

	public String[][] exceldata() throws BiffException, IOException {

		FileInputStream excel = new FileInputStream("E:\\Automation\\Data\\usertestdata.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet(0);
		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		String testdat[][] = new String[rowCount - 1][columnCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				testdat[i - 1][j] = sheet.getCell(j, i).getContents();
			}
		}
		return testdat;
	}

	@BeforeTest
	public void beforetest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\THI1805386\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "logindata")
	public void loginwithcredentials(String uname, String pwd) {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("uname");
		WebElement Password = driver.findElement(By.id("txtPassword"));
		Password.sendKeys("pwd");
		WebElement Login = driver.findElement(By.id("btnLogin"));
		Login.click();
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
