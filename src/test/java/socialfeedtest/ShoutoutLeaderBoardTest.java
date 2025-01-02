package socialfeedtest;

import basetest.BaseTest;
import org.testng.annotations.BeforeClass;
import pages.homepage.HomePage;

public class ShoutoutLeaderBoardTest extends BaseTest {

    @BeforeClass
    public void commonState() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
    }

}
