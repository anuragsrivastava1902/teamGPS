package socialfeedtest;

import basetest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.socialFeed.CustomRewardRedemptionPage;
import pages.homepage.socialFeed.GiftCardRedemptionPage;
import pages.homepage.socialFeed.RewardsAndRedemptionHistoryPage;
import pages.homepage.socialFeed.SocialFeedPage;
import pages.loginPage.LoginPage;

import java.time.Duration;

public class CustomRewardRedemptionTest extends BaseTest {

    @AfterMethod
    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav//img[@alt='user']"))));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Log Out']"))));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Log Out']"))).click();
    }

    @Test(priority = 1)
    public void testCustomRewardRedemptionForUSA() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();

        SocialFeedPage socialFeedPage = new SocialFeedPage(driver);
        socialFeedPage.clickOnRedeemPointsButton();

        RewardsAndRedemptionHistoryPage rewardsAndRedemptionHistoryPage = new RewardsAndRedemptionHistoryPage(driver);
        rewardsAndRedemptionHistoryPage.clickOnRewardsTab();
        rewardsAndRedemptionHistoryPage.selectCustomRewardRadioButton();

        CustomRewardRedemptionPage customRewardRedemptionPage = new CustomRewardRedemptionPage(driver);
        //customRewardRedemptionPage.enterRewardNameToSearch("Pickelbally");
        customRewardRedemptionPage.clickOnSearchButton("Pickelball");
    }


    @Test(priority = 2,enabled = false)
    public void testCustomRewardRedemptionForPhilippines() throws InterruptedException {
        driver.get("https://itbd-stage-frontend.team-gps.net/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("shri.yanshraj@yopmail.com", "John@123");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
        SocialFeedPage socialFeedPage = new SocialFeedPage(driver);
        socialFeedPage.clickOnRedeemPointsButton();

        RewardsAndRedemptionHistoryPage rewardsAndRedemptionHistoryPage = new RewardsAndRedemptionHistoryPage(driver);
        rewardsAndRedemptionHistoryPage.clickOnRewardsTab();
        rewardsAndRedemptionHistoryPage.selectCustomRewardRadioButton();

        CustomRewardRedemptionPage customRewardRedemptionPage = new CustomRewardRedemptionPage(driver);
//        customRewardRedemptionPage.enterRewardNameToSearch("Pickelball");
//        customRewardRedemptionPage.clickOnSearchButton();
    }

    @Test(priority = 3,enabled = false)
    public void testCustomRewardRedemptionForIndia() throws InterruptedException {
        driver.get("https://itbd-stage-frontend.team-gps.net/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tanishk.patidar@yopmail.com", "John@123");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
        SocialFeedPage socialFeedPage = new SocialFeedPage(driver);
        socialFeedPage.clickOnRedeemPointsButton();
        RewardsAndRedemptionHistoryPage rewardsAndRedemptionHistoryPage = new RewardsAndRedemptionHistoryPage(driver);
        rewardsAndRedemptionHistoryPage.clickOnRewardsTab();
        rewardsAndRedemptionHistoryPage.selectCustomRewardRadioButton();

        CustomRewardRedemptionPage customRewardRedemptionPage = new CustomRewardRedemptionPage(driver);
//        customRewardRedemptionPage.enterRewardNameToSearch("Pickelball");
//        customRewardRedemptionPage.clickOnSearchButton();
    }


}
