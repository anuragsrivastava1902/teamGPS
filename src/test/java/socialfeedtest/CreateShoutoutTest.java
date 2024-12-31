package socialfeedtest;


import basetest.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.socialfeed.SocialFeedPage;

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
        Thread.sleep(2000);
    }

}
