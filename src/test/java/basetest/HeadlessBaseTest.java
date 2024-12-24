package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.loginPage.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.TimeUnit;

public class HeadlessBaseTest {

    private static final String USERNAME = "lucas.sarzo@yopmail.com";
    private static final String PASSWORD = "John@123";
    protected WebDriver driver;
    // Creating a logger instance for the class
    public static final Logger logger = LoggerFactory.getLogger(HeadlessBaseTest.class);

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        logger.info("Setting up testing in the headless mode");
        options.addArguments("window-size=1200x600");
        driver = new ChromeDriver(options);
        logger.info("Initialising the chromeDriver");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//         Go to the login page
        driver.get("https://itbd-stage-frontend.team-gps.net/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD);
        logger.info("Login successfull");
    }

    @AfterClass
    public void tearDown() {
        //this is just for testing
        System.out.println("WebDriver quitting: " + driver.hashCode());
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }
}
