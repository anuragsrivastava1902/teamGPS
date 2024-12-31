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

        // Create the shoutout
        Thread.sleep(4000);
        socialFeed.clickOnAddPointsIcon();
        socialFeed.clickOnAddEmployee();
        String recipientName = "Shri Yanshraj"; // Data for verification
        socialFeed.selectNameFromDropdown(recipientName);
        socialFeed.clickAddHastag();
        String hashtag = "#Humility"; // Data for verification
        socialFeed.selectTagFromDropdown(hashtag);
        socialFeed.clickAddEmoji();
        String emoji1 = "\uD83D\uDE1C"; // Data for verification
        socialFeed.selectEmoji(emoji1);
        socialFeed.clickAddEmoji();
        String emoji2 = "\uD83D\uDE00"; // Data for verification
        socialFeed.selectEmoji(emoji2);
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(4000); // Wait for the shoutout to appear in the listing

        // Verify the shoutout in the listing
        boolean isShoutoutVisible = socialFeed.verifyShoutoutDetails(recipientName, "+10");
        Assert.assertTrue(isShoutoutVisible, "Shoutout is not visible in the listing for the recipient: " + recipientName);
    }

    @Test(priority = 2)
    public void shoutoutToMultipleRecipient() throws InterruptedException {
        SocialFeedPage socialFeed = new SocialFeedPage(driver);

        // Create the shoutout
        Thread.sleep(4000);
        socialFeed.clickOnAddPointsIcon();
        socialFeed.clickOnAddEmployee();
        String recipient1 = "Tanishk Patidar"; // Data for verification
        socialFeed.selectNameFromDropdown(recipient1);
        socialFeed.clickOnAddEmployee();
        String recipient2 = "Anshul Uniyal"; // Data for verification
        socialFeed.selectNameFromDropdown(recipient2);
        socialFeed.clickAddHastag();
        String hashtag1 = "#Humility"; // Data for verification
        socialFeed.selectTagFromDropdown(hashtag1);
        socialFeed.clickAddHastag();
        String hashtag2 = "#Accountability"; // Data for verification
        socialFeed.selectTagFromDropdown(hashtag2);
        socialFeed.clickAddEmoji();
        String emoji = "\uD83D\uDE1C"; // Data for verification
        socialFeed.selectEmoji(emoji);
        socialFeed.clickAddGif();
        socialFeed.selectGif(0);
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(2000); // Wait for the shoutout to appear in the listing

        // Verify the shoutout in the listing for both recipients and points
//        String expectedPoints = "+10"; // Example points for validation
        boolean isShoutoutVisible = socialFeed.verifyShoutoutWithMultipleRecipientsAndPoints(recipient1, recipient2, "+10");
        Assert.assertTrue(isShoutoutVisible, "Shoutout is not visible in the listing for recipients: " + recipient1 + " and " + recipient2 + " with points: " );
    }



}
