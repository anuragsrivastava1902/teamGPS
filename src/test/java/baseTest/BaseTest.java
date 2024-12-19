package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.loginPage.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final String USERNAME = "lucas.sarzo@yopmail.com";
    private static final String PASSWORD = "John@123";

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
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
