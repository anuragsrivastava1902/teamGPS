package socialfeedtest;

import basetest.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.socialfeed.SocialFeedPage;

public class ShoutoutFilterTest extends BaseTest {

    @BeforeClass
    public void commonState() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
    }

    @AfterMethod
    public void tearDown() {
        driver.navigate().refresh(); // Refresh to reset the page state
    }

    @Test
    public void shoutoutGivenFilterList() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(2000);
        socialFeed.clickAllShoutoutsDropown("Given");
        Thread.sleep(2000);
    }
    @Test
    public void shoutoutReceivedFilterList() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(2000);
        socialFeed.clickAllShoutoutsDropown("Received");
        Thread.sleep(2000);
    }
    @Test
    public void departmentsDropdownFilterList() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(2000);
        socialFeed.clickDepartmentsDropdown("Test");
        Thread.sleep(2000);
    }
}
