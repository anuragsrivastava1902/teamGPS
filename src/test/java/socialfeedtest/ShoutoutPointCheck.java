package socialfeedtest;

import basetest.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.socialfeed.SocialFeedPage;

public class ShoutoutPointCheck extends BaseTest {

    @BeforeMethod
    public void commonState() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
    }

    @AfterMethod
    public void tearDown() {
        driver.navigate().refresh(); // Refresh to reset the page state
    }

    @Test(priority = 1)
    public void pointallocationlimitcheck() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.charactercheck("+600");
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Tanishk Patidar");
        socialFeed.clickAddHastag();
        socialFeed.selectTagFromDropdown("#Humility");
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void pointallocationcheckmultiplerecipient() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.charactercheck("+600");
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Tanishk Patidar");
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Anshul Uniyal");
        socialFeed.clickAddHastag();
        socialFeed.selectTagFromDropdown("#Humility");
        socialFeed.clickAddHastag();
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(2000);

    }
}
