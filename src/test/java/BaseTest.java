import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.loginPage.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

	protected WebDriver driver;
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Initialize the Page Object
		//LoginPage loginPage = new LoginPage(driver);

		// Navigate to the login page
		driver.get("https://itbd-stage-frontend.team-gps.net/login");

//		loginPage.enterUsername("lucas.sarzo@yopmail.com");
//		loginPage.clickNextButton();
//		loginPage.enterPassword("John@123");
//		loginPage.clickLoginButton();
	}

	//@AfterSuite
	public void tearDown() {
		// Close the driver after the test
		if (driver != null) {
			driver.quit();
		}
	}
}
