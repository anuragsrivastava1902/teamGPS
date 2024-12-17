package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.loginPage.LoginPage;

import java.util.concurrent.TimeUnit;

public class HeadlessBaseTest {

	private static final String USERNAME = "lucas.sarzo@yopmail.com";
	private static final String PASSWORD = "John@123";

	protected WebDriver driver;
	@BeforeClass
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		// Set Chrome to run in headless mode
		options.addArguments("--headless");
		// Optional: Set window size (otherwise it defaults to a small size)
		options.addArguments("window-size=1200x600");
		// Initialize WebDriver with the headless options
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Go to the login page
		driver.get("https://itbd-stage-frontend.team-gps.net/login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(USERNAME,PASSWORD);
	}

	@AfterClass
	public void tearDown() {
		//this is just for testing
		System.out.println("WebDriver quitting: " + driver.hashCode());
		// Close the driver after the test
		if (driver != null) {
			driver.quit();
		}
	}
}
