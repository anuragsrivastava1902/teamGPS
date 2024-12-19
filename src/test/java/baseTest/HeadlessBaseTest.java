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
        options.addArguments("--headless");
        options.addArguments("window-size=1200x600");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//         Go to the login page
        driver.get("https://itbd-stage-frontend.team-gps.net/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD);
    }

    @AfterClass
    public void tearDown() {
        //this is just for testing
        System.out.println("WebDriver quitting: " + driver.hashCode());
        if (driver != null) {
            driver.quit();
        }
    }
}
