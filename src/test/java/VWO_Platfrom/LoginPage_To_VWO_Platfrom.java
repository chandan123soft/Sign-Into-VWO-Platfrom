package VWO_Platfrom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginPage_To_VWO_Platfrom {

	WebDriver driver;
	
	@BeforeSuite
	public void navigateToTheURL() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.vwo.com/#/login");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Login - VWO", "Unable to open the App URL");

	}

	@Test()
	public void loginCrenditial() throws InterruptedException {
		WebElement emailAddress = driver.findElement(By.xpath("//input[@id='login-username']"));
		emailAddress.sendKeys("WrongCred94npu2yyb0@esiix.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='login-password']"));
		password.sendKeys("Wingify@123");
		WebElement signInButton = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
		signInButton.click();

        String errorMessage = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']")).getText();
		Assert.assertEquals(errorMessage, "Your email, password, IP address or location did not match");
		
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
