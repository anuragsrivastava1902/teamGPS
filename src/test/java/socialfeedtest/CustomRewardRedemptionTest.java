package socialfeedtest;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.socialfeed.CustomRewardRedemptionPage;
import pages.homepage.socialfeed.RewardsAndRedemptionHistoryPage;
import pages.homepage.socialfeed.SocialFeedPage;
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
        //positive test case to find the existing custom reward
        customRewardRedemptionPage.enterRewardNameAndSearch("Pickelball");
    }


    @Test(priority = 2)
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
        customRewardRedemptionPage.enterRewardNameAndSearch("Pickelball");
    }

    @Test(priority = 3)
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
        customRewardRedemptionPage.enterRewardNameAndSearch("Pickelball");
    }


}
