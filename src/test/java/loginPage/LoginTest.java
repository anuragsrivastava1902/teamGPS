package loginPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {


	WebDriver driver;
		
		@BeforeClass
		void setup() {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://itbd-qa-frontend.team-gps.net/login");
			driver.manage().window().maximize();
		}
		
		@Test
		void loginTest() {
			LoginPage login = new LoginPage(driver);
			login.enterUsername("ralph.sharma@yopmail.com");
			login.clickNext();
			login.enterPassword("John@123");
			login.clickLogin();
		}
		
		@AfterClass
		void browserQuit() {
			driver.quit();
		}
		

}