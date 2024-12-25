package socialfeedtest;

import basetest.BaseTest;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.socialfeed.GiftCardRedemptionPage;
import pages.homepage.socialfeed.RewardsAndRedemptionHistoryPage;
import pages.homepage.socialfeed.SocialFeedPage;
import pages.loginPage.LoginPage;

import java.time.Duration;

public class GiftCardRedemptionTest extends BaseTest {

    //@Test
    public void apicheck() {
        String jwtToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyNzk5LCJ1c2VybmFtZSI6Imx1Y2FzLnNhcnpvQHlvcG1haWwuY29tIiwiZXhwIjoxNzM1MDUzODY3LCJlbWFpbCI6Imx1Y2FzLnNhcnpvQHlvcG1haWwuY29tIiwibG9naW5fdHlwZSI6MX0.5rd-mjwjjMVezPt8-NbQ1fy8ltp6hy01xq8r6VjG0uA";

        Response response = RestAssured.given().header("Authorization", "Bearer " + jwtToken).when().get("https://itbd-stage-backend.team-gps.net/company/get_data/");
        System.out.println(response.getBody().asString());
        System.out.println(response.jsonPath().getString("data.name"));
    }

    @Test(priority = 1)
    public void testGiftCardRedemptionForUSA() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();

        SocialFeedPage socialFeedPage = new SocialFeedPage(driver);
        socialFeedPage.clickOnRedeemPointsButton();

        RewardsAndRedemptionHistoryPage rewardsAndRedemptionHistoryPage = new RewardsAndRedemptionHistoryPage(driver);
        rewardsAndRedemptionHistoryPage.clickOnRewardsTab();
        rewardsAndRedemptionHistoryPage.selectGiftCardRadioButton();

        GiftCardRedemptionPage giftCardRedemptionPage = new GiftCardRedemptionPage(driver);
        giftCardRedemptionPage.clickOnPointsToRedeemDropdown("50");
        giftCardRedemptionPage.clickOnGiftCardRedeemButton();
    }

    @AfterMethod
    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav//img[@alt='user']"))));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Log Out']"))));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Log Out']"))).click();
    }

    @Test(priority = 2)
    public void testGiftCardRedemptionForPhilippines() throws InterruptedException {
        driver.get("https://itbd-stage-frontend.team-gps.net/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("shri.yanshraj@yopmail.com", "John@123");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
        SocialFeedPage socialFeedPage = new SocialFeedPage(driver);
        socialFeedPage.clickOnRedeemPointsButton();
        RewardsAndRedemptionHistoryPage rewardsAndRedemptionHistoryPage = new RewardsAndRedemptionHistoryPage(driver);
        rewardsAndRedemptionHistoryPage.clickOnRewardsTab();
        rewardsAndRedemptionHistoryPage.selectGiftCardRadioButton();
        GiftCardRedemptionPage giftCardRedemptionPage = new GiftCardRedemptionPage(driver);
        giftCardRedemptionPage.clickOnPointsToRedeemDropdown("17");
        giftCardRedemptionPage.clickOnGiftCardRedeemButton();
    }

    @Test(priority = 3)
    public void testGiftCardRedemptionForIndia() throws InterruptedException {
        driver.get("https://itbd-stage-frontend.team-gps.net/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tanishk.patidar@yopmail.com", "John@123");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
        SocialFeedPage socialFeedPage = new SocialFeedPage(driver);
        socialFeedPage.clickOnRedeemPointsButton();
        RewardsAndRedemptionHistoryPage rewardsAndRedemptionHistoryPage = new RewardsAndRedemptionHistoryPage(driver);
        rewardsAndRedemptionHistoryPage.clickOnRewardsTab();
        rewardsAndRedemptionHistoryPage.selectGiftCardRadioButton();
        GiftCardRedemptionPage giftCardRedemptionPage = new GiftCardRedemptionPage(driver);
        giftCardRedemptionPage.clickOnPointsToRedeemDropdown("13");
        giftCardRedemptionPage.clickOnGiftCardRedeemButton();
    }


}
