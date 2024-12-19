package socialFeedTest;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.homePage.socialFeed.SocialFeedPage;

public class ShoutoutTest extends BaseTest {

    @Test
    public void testShoutouts() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();

        SocialFeedPage socialFeedPage = new SocialFeedPage(driver);
        //socialFeedPage.clickShoutInputField();
        socialFeedPage.filterShoutOutCardsByUser();
    }
}
