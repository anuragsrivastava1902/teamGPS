package oneOnOneMeetingTest.cancelMeetingTest;

import baseTest.HeadlessBaseTest;
import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.homePage.meetings.oneOnOneMeetings.MeetingListingPage;

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
