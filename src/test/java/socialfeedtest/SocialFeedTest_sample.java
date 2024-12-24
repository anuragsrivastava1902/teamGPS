package socialfeedtest;

import basetest.BaseTest;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.socialFeed.*;

public class SocialFeedTest_sample extends BaseTest {

    @Test
    public void socialFeedTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();

        SocialFeedPage socialFeedPage = new SocialFeedPage(driver);
        socialFeedPage.clickOnRedeemPointsButton();

        /* use this RewardsAndRedemptionHistoryPage class to switch between the rewards and redemption history tab,
        also use this class to select between the gift card and custom reward radio button*/
        RewardsAndRedemptionHistoryPage rewardsAndRedemptionHistoryPage = new RewardsAndRedemptionHistoryPage(driver);
//        rewardsAndRedemptionHistoryPage.clickOnRewardsTab();
//        rewardsAndRedemptionHistoryPage.selectGiftCardRadioButton();
        rewardsAndRedemptionHistoryPage.clickOnRedemptionHistoryTab();
        //rewardsAndRedemptionHistoryPage.selectCustomRewardRadioButton();


//        GiftCardRedemptionPage giftCardRedemptionPage = new GiftCardRedemptionPage(driver);
//        giftCardRedemptionPage.clickOnPointsToRedeemDropdown("15");
//        giftCardRedemptionPage.clickOnGiftCardRedeemButton();

//        CustomRewardRedemptionPage customRewardRedemptionPage = new CustomRewardRedemptionPage(driver);
//        customRewardRedemptionPage.enterRewardNameToSearch("allo");
//        customRewardRedemptionPage.clickOnSearchButton();

        RedemptionHistoryPage redemptionHistoryPage = new RedemptionHistoryPage(driver);
        redemptionHistoryPage.clickOnFilterIcon();
        //redemptionHistoryPage.clickOnPointsRedeemedFilter();
        //redemptionHistoryPage.clickOnAmountFilter();
        //redemptionHistoryPage.setPointBalance();
        //redemptionHistoryPage.clickOnDeductionTypeDropdown();
        //redemptionHistoryPage.clickOnRedemptionStatusDropdown();
        //redemptionHistoryPage.clickOnResendMailButton();
        redemptionHistoryPage.selectRedemptionDate();
        Thread.sleep(5000);

        Thread.sleep(15000);
    }

}
