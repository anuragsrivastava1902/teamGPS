package socialfeedtest;

import basetest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.socialfeed.RedemptionHistoryPage;
import pages.homepage.socialfeed.RewardsAndRedemptionHistoryPage;
import pages.homepage.socialfeed.SocialFeedPage;

public class RedemptionHistoryFiltersTest extends BaseTest {

    @BeforeClass
    public void common() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
        SocialFeedPage socialFeedPage = new SocialFeedPage(driver);
        socialFeedPage.clickOnRedeemPointsButton();
        RewardsAndRedemptionHistoryPage rewardsAndRedemptionHistoryPage = new RewardsAndRedemptionHistoryPage(driver);
        rewardsAndRedemptionHistoryPage.clickOnRedemptionHistoryTab();
    }

    @Test(priority = 0)
    public void testDeductionTypeByGiftCard() throws InterruptedException {
        RedemptionHistoryPage redemptionHistoryPage = new RedemptionHistoryPage(driver);
        redemptionHistoryPage.clickOnFilterIcon();
        redemptionHistoryPage.clickOnDeductionTypeDropdown(0);
    }

    @Test(priority = 1)
    public void testDeductionTypeByCustomReward() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
        SocialFeedPage socialFeedPage = new SocialFeedPage(driver);
        socialFeedPage.clickOnRedeemPointsButton();
        RewardsAndRedemptionHistoryPage rewardsAndRedemptionHistoryPage = new RewardsAndRedemptionHistoryPage(driver);
        rewardsAndRedemptionHistoryPage.clickOnRedemptionHistoryTab();
        RedemptionHistoryPage redemptionHistoryPage = new RedemptionHistoryPage(driver);
        redemptionHistoryPage.clickOnFilterIcon();
        redemptionHistoryPage.clickOnDeductionTypeDropdown(1);
    }

    @Test(priority = 2)
    public void testDeductionTypeByManualRedemption() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
        SocialFeedPage socialFeedPage = new SocialFeedPage(driver);
        socialFeedPage.clickOnRedeemPointsButton();
        RewardsAndRedemptionHistoryPage rewardsAndRedemptionHistoryPage = new RewardsAndRedemptionHistoryPage(driver);
        rewardsAndRedemptionHistoryPage.clickOnRedemptionHistoryTab();
        RedemptionHistoryPage redemptionHistoryPage = new RedemptionHistoryPage(driver);
        redemptionHistoryPage.clickOnFilterIcon();
        redemptionHistoryPage.clickOnDeductionTypeDropdown(2);
    }

    @Test(priority = 3)
    public void testDeductionTypeByCorrection() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
        SocialFeedPage socialFeedPage = new SocialFeedPage(driver);
        socialFeedPage.clickOnRedeemPointsButton();
        RewardsAndRedemptionHistoryPage rewardsAndRedemptionHistoryPage = new RewardsAndRedemptionHistoryPage(driver);
        rewardsAndRedemptionHistoryPage.clickOnRedemptionHistoryTab();
        RedemptionHistoryPage redemptionHistoryPage = new RedemptionHistoryPage(driver);
        redemptionHistoryPage.clickOnFilterIcon();
        redemptionHistoryPage.clickOnDeductionTypeDropdown(3);
    }

    @Test(priority = 4)
    public void testDeductionTypeByOthers() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
        SocialFeedPage socialFeedPage = new SocialFeedPage(driver);
        socialFeedPage.clickOnRedeemPointsButton();
        RewardsAndRedemptionHistoryPage rewardsAndRedemptionHistoryPage = new RewardsAndRedemptionHistoryPage(driver);
        rewardsAndRedemptionHistoryPage.clickOnRedemptionHistoryTab();
        RedemptionHistoryPage redemptionHistoryPage = new RedemptionHistoryPage(driver);
        redemptionHistoryPage.clickOnFilterIcon();
        redemptionHistoryPage.clickOnDeductionTypeDropdown(4);
    }

}
