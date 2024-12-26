package socialfeedtest;

import basetest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.socialfeed.SocialFeedPage;

public class SocialTest1 extends BaseTest {

    @BeforeClass
    public void commonState() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
    }

@Test
    public void click() throws InterruptedException {
    HomePage homePage = new HomePage(driver);
    homePage.clickOnSocialFeed();
    SocialFeedPage socialFeed= new SocialFeedPage(driver);
  Thread.sleep(4000);
//    socialFeed.clickOnAddPointsIcon();
//    socialFeed.clickOnAddEmployee();
//    socialFeed.selectNameFromDropdown("Tanishk Patidar");
//    socialFeed.clickAddHastag();
//    socialFeed.selectTagFromDropdown("#Humility");
//    Thread.sleep(2000);
//    socialFeed.clickTagUser();
//    Thread.sleep(2000);
//    socialFeed.selectNameFromDropdown("Anshul Uniyal");
//    socialFeed.clickAddEmoji();
//    socialFeed.selectEmoji("\uD83D\uDE1C");
//    socialFeed.clickAddEmoji();
//    socialFeed.selectEmoji("\uD83D\uDE00");
//    socialFeed.clickAddGif();
//    Thread.sleep(2000);
//    socialFeed.searchGif("welcome");
//    Thread.sleep(1000);
//    socialFeed.selectGif(0);
//    socialFeed.clickAddGif();
//    socialFeed.selectGif(1);
        socialFeed.clickOnImageIcon();
        Thread.sleep(2000);
        socialFeed.uploadFile();
        Thread.sleep(10000);
//    socialFeed.uploadFile("C:\\Users\\hp\\Pictures\\as.jpg");

    Thread.sleep(5000);

}
    @Test(priority = 1)
    public void shoutoutToSingleRecipient() throws InterruptedException {

        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.clickOnAddPointsIcon();
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Tanishk Patidar");
        socialFeed.clickAddHastag();
        socialFeed.selectTagFromDropdown("#Humility");
        socialFeed.clickAddEmoji();
        socialFeed.selectEmoji("\uD83D\uDE1C");
        socialFeed.clickAddEmoji();
        socialFeed.selectEmoji("\uD83D\uDE00");
        socialFeed.clickAddGif();
//        socialFeed.searchGif("welcome");
        socialFeed.selectGif(0);
        socialFeed.clickAddGif();
        Thread.sleep(2000);
        socialFeed.selectGif(1);
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(10000);
    }
@Test(priority = 2)
    public void shoutoutToMultipleRecipient() throws InterruptedException {
    SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(40000);
        socialFeed.clickOnAddPointsIcon();
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Tanishk Patidar");
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Anshul Uniyal");
        socialFeed.clickAddHastag();
        socialFeed.selectTagFromDropdown("#Humility");
        socialFeed.clickAddHastag();
        socialFeed.selectTagFromDropdown("#Accountability");
        socialFeed.clickAddEmoji();
        socialFeed.selectEmoji("\uD83D\uDE1C");
        socialFeed.clickAddGif();
        socialFeed.selectGif(0);
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(10000);
    }
    @Test
    public void shoutoutGivenFilterList() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(10000);
        socialFeed.clickAllShoutoutsDropown("Given");
        Thread.sleep(5000);
    }
    @Test
    public void shoutoutReceivedFilterList() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);        Thread.sleep(10000);
        socialFeed.clickAllShoutoutsDropown("Received");
        Thread.sleep(5000);
    }
    @Test
    public void departmentsDropdownFilterList() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);        Thread.sleep(5000);
        socialFeed.clickDepartmentsDropdown("Test");
        Thread.sleep(5000);
    }
    @Test
    public void ReactionToShoutout() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.giveReactionToShoutout("😀, grinning");
        Thread.sleep(4000);
    }
    @Test
    public void addcommenttoshoutout() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.clickAddComment();
        Thread.sleep(2000); // Optional, but helps with ensuring actions happen in sequence

        // Write a comment
        socialFeed.writeComment("This is a sample comment!");
        Thread.sleep(2000); // Optional, helps with timing

        // Tag a user in the comment (adjust user name accordingly)
        String userName = "John Doe";
        socialFeed.tagUser(userName);
        Thread.sleep(2000); // Optional, helps with timing

        // Add an emoji to the comment (adjust emoji label accordingly)
        String emojiAriaLabel = "😀, grinning";
        socialFeed.addEmoji(emojiAriaLabel);
        Thread.sleep(2000); // Optional, helps with timing

        // Upload a file if needed (adjust file path accordingly)
        String filePath = "C:\\path\\to\\your\\image.jpg";
        socialFeed.uploadFile(filePath);
        Thread.sleep(2000); // Optional, helps with timing

        // Submit the comment
//        socialFeed.submitComment();
        Thread.sleep(5000);
    }

}
