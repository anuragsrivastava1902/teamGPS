package logintest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.loginPage.LoginPage;
import basetest.BaseTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://itbd-stage-frontend.team-gps.net/login");
    }

    @AfterClass
    public void tearDown() {
        //this is just for testing
        System.out.println("WebDriver quitting: " + driver.hashCode());
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav//img[@alt='user']"))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Log Out']"))));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Log Out']"))).click();
    }

    @Test(dataProvider = "userData")
    public void testValidLogin(String user, String pass) {
        // -- Interact with the login page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(user);
        loginPage.clickNextButton();
        loginPage.enterPassword(pass);
        loginPage.clickLoginButton();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://itbd-stage-frontend.team-gps.net/admin/home","test failed for the user: "+user);
    }

    @DataProvider(name = "userData")
    public Object[][] provideUserData() {
        return new Object[][] {
                { "lucas.sarzo@yopmail.com", "John@123" }, //correct details
                { "shri.yanshraj@yopmail.com", "John@123" }, //correct details
                {"shri.yanshraj@yopmail.com","12345678"} //incorrect password
        };
    }

    public void testInvalidLogin() {

        // -- Interact with the login page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("lucas.sarzo@yopmail.com");
        loginPage.clickNextButton();
        loginPage.enterPassword("John@123");
        loginPage.clickLoginButton();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://itbd-stage-frontend.team-gps.net/login");
    }
}
