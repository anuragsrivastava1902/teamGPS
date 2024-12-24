package logintest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage.LoginPage;
import basetest.BaseTest;

public class LoginTest extends BaseTest {
    @Test
    public void testValidLogin(){

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
        Assert.assertEquals(driver.getCurrentUrl(), "https://itbd-stage-frontend.team-gps.net/admin/home");
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
