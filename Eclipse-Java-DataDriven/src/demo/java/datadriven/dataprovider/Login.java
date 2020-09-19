package demo.java.datadriven.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	String[][] data = { { "Admin", "admin123" }, { "Admin", "admin1234" }, { "Admin1", "admin123" },
			{ "Admin1", "admin1234" } };

	@DataProvider(name = "logindata")
	public String[][] logindataprovider() {
		return data;

	}

	@Test(dataProvider="logindata")
	public void loginwithInvalidcredentials(String uname,String pwd) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\THI1805386\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("uname");
		WebElement Password = driver.findElement(By.id("txtPassword"));
		Password.sendKeys("pwd");
		WebElement Login = driver.findElement(By.id("btnLogin"));
		Login.click();
		driver.quit();
	}
}
