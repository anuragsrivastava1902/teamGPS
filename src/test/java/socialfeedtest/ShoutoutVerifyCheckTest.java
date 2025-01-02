package socialfeedtest;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.socialfeed.SocialFeedPage;

public class ShoutoutVerifyCheckTest extends BaseTest {
    @BeforeClass
    public void commonState() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
    }

    @AfterMethod
    public void tearDown() {
        driver.navigate().refresh(); // Refresh to reset the page state
    }

    @Test(priority = 1)
    public void shoutoutToSingleRecipient() throws InterruptedException {
        SocialFeedPage socialFeed = new SocialFeedPage(driver);
        Thread.sleep(4000);
        socialFeed.clickOnAddPointsIcon();
        socialFeed.clickOnAddEmployee();
        String recipientName = "Shri Yanshraj";
        socialFeed.selectNameFromDropdown(recipientName);
        socialFeed.clickAddHastag();
        String hashtag = "#Humility";
        socialFeed.selectTagFromDropdown(hashtag);
        socialFeed.clickAddEmoji();
        String emoji1 = "\uD83D\uDE1C";
        socialFeed.selectEmoji(emoji1);
        socialFeed.clickAddEmoji();
        String emoji2 = "\uD83D\uDE00";
        socialFeed.selectEmoji(emoji2);
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(4000);

        boolean isShoutoutVisible = socialFeed.verifyShoutoutDetails(recipientName, "+10");
        Assert.assertTrue(isShoutoutVisible, "Shoutout is not visible in the listing for the recipient: " + recipientName);
    }

    @Test(priority = 2)
    public void shoutoutToMultipleRecipient() throws InterruptedException {
        SocialFeedPage socialFeed = new SocialFeedPage(driver);
        Thread.sleep(4000);
//        socialFeed.clickOnAddPointsIcon();
        String point = "+1";
        socialFeed.charactercheck(point);
        socialFeed.clickOnAddEmployee();
        String recipient1 = "Tanishk Patidar";
        socialFeed.selectNameFromDropdown(recipient1);
        Thread.sleep(1000);
        socialFeed.clickOnAddEmployee();
        String recipient2 = "Anshul Uniyal";
        socialFeed.selectNameFromDropdown(recipient2);
        socialFeed.clickAddHastag();
        String hashtag1 = "#Humility";
        socialFeed.selectTagFromDropdown(hashtag1);
        socialFeed.clickAddHastag();
        String hashtag2 = "#Accountability";
        socialFeed.selectTagFromDropdown(hashtag2);
        socialFeed.clickAddEmoji();
        String emoji = "\uD83D\uDE1C";
        socialFeed.selectEmoji(emoji);
        socialFeed.clickAddGif();
        socialFeed.selectGif(0);
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(2000);

        boolean isShoutoutVisible = socialFeed.verifyShoutoutWithMultipleRecipientsAndPoints(recipient1, recipient2, point);
        Assert.assertTrue(isShoutoutVisible, "Shoutout is not visible in the listing for recipients: " + recipient1 + " and " + recipient2 + " with points:" +point);
    }
}

