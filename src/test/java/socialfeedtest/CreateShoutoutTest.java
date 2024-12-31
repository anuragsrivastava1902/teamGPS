package socialfeedtest;


import basetest.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.socialfeed.SocialFeedPage;

import java.util.Arrays;
import java.util.List;

public class CreateShoutoutTest extends BaseTest {

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

        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(4000);
//        socialFeed.clickOnAddPointsIcon();
        socialFeed.charactercheck("+1");
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Tanishk Patidar");
        socialFeed.clickAddHastag();
        socialFeed.selectTagFromDropdown("#Humility");
        socialFeed.clickAddEmoji();
        socialFeed.selectEmoji("\uD83D\uDE1C");
        socialFeed.clickAddEmoji();
        socialFeed.selectEmoji("\uD83D\uDE00");
        socialFeed.clickAddGif();
        socialFeed.selectGif(0);
        socialFeed.clickAddGif();
        Thread.sleep(2000);
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(2000);

    }

    @Test(priority = 3)
    public void shoutoutDelete() throws InterruptedException {
        SocialFeedPage socialFeed = new SocialFeedPage(driver);
        Thread.sleep(4000);
        socialFeed.shoutoutsdelete();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void shoutoutToMultipleRecipient() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(4000);
//        socialFeed.clickOnAddPointsIcon();
        socialFeed.charactercheck("+1");
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
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void shoutoutToMultipleRecipients() throws InterruptedException {
        SocialFeedPage socialFeed = new SocialFeedPage(driver);
        Thread.sleep(4000);
        socialFeed.charactercheck("+1");
        List<String> recipients = Arrays.asList("Tanishk Patidar", "Anshul Uniyal", "Test Emp", "Test Join", "Shri Yanshraj", "Test Emp1", "Anshul Jcentrix", "Ryan Siwarkar", "Anshul Samatre", "Test Test1");
        socialFeed.addRecipients(recipients);
        socialFeed.charactercheck("@");
        socialFeed.selectNameFromDropdown("Test2 Test");
        socialFeed.clickAddHastag();
        socialFeed.selectTagFromDropdown("#Accountability");
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(3000);
    }
}
