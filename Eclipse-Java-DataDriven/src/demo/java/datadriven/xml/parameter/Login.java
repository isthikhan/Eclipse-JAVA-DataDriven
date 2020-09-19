package demo.java.datadriven.xml.parameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {

	@Test
	public void loginwithBothCorrect() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\THI1805386\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("Admin");
		WebElement Password = driver.findElement(By.id("txtPassword"));
		Password.sendKeys("admin123");
		WebElement Login = driver.findElement(By.id("btnLogin"));
		Login.click();
		driver.quit();

	}

}
