package oneononemeetingtest.createmeetingtest;

import basetest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.meetings.oneononemeetings.MeetingListingPage;
import pages.homepage.meetings.oneononemeetings.createnewmeeting.ActivityTabPage;
import pages.homepage.meetings.oneononemeetings.createnewmeeting.CreateEventPage;
import pages.homepage.meetings.oneononemeetings.createnewmeeting.EditMeetingPage;
import pages.homepage.meetings.oneononemeetings.createnewmeeting.SelectTemplatePage;

public class OneOnActivityTest extends BaseTest {

    private static final String MEETING_RECIPIENT = "Shri";
    private static final String MEETING_TITLE = "1:1 meeting with Shri 2nd top";

    @BeforeClass
    public void commonState() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMeetings();
        homePage.clickOnOneOnOneMeetings();
        MeetingListingPage meetingListingPage = new MeetingListingPage(driver);
        meetingListingPage.clickCreateMeeting();
        CreateEventPage createEventPage = new CreateEventPage(driver);
        createEventPage.addRecipient(MEETING_RECIPIENT);
        createEventPage.setEventTitle(MEETING_TITLE);
        createEventPage.clickOnCreateButton();

        SelectTemplatePage selectTemplatePage = new SelectTemplatePage(driver);
        selectTemplatePage.clickOnFromScratch();
        selectTemplatePage.clickSaveAndNextButton();
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnActivityTab();
    }

    @Test
    public void shoutoutsGivenTab() throws InterruptedException {
        ActivityTabPage activityTabPage = new ActivityTabPage(driver);
        activityTabPage.getShoutoutsGivenCard();
        Thread.sleep(3000);

    }

    @Test
    public void shoutoutsRecivedTab() throws InterruptedException {
        ActivityTabPage activityTabPage = new ActivityTabPage(driver);
        activityTabPage.getShoutoutsReceivedCard();
        Thread.sleep(3000);
    }

    @Test
    public void csatResponses() throws InterruptedException {
        ActivityTabPage activityTabPage = new ActivityTabPage(driver);
        activityTabPage.getCsatResponsesCard();
        Thread.sleep(3000);
    }
    @Test
    public void activitySinceTheLastMeeting() throws InterruptedException {
        ActivityTabPage activityTabPage = new ActivityTabPage(driver);
         activityTabPage.getDateRangeDropdown();
         Thread.sleep(2000);
    }
}
