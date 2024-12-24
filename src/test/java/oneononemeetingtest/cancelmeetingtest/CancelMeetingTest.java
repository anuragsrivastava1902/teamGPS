package oneononemeetingtest.cancelmeetingtest;

import basetest.HeadlessBaseTest;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.meetings.oneononemeetings.MeetingListingPage;

public class CancelMeetingTest extends HeadlessBaseTest {

    @Test(invocationCount = 1)
    public void testCancelMeeting() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMeetings();
        homePage.clickOnOneOnOneMeetings();

        MeetingListingPage meetingListingPage = new MeetingListingPage(driver);
        meetingListingPage.clickCancelMeeting(1);
    }
}
