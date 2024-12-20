package oneOnOneMeetingTest.createMeetingTest;

import baseTest.BaseTest;
import baseTest.HeadlessBaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.homePage.meetings.oneOnOneMeetings.MeetingListingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.ActivityTabPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.CreateEventPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.EditMeetingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.SelectTemplatePage;

public class OneOnActivityTest extends HeadlessBaseTest {

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
    public void shoutoutsGivenTab(){
        ActivityTabPage activityTabPage = new ActivityTabPage(driver);
        activityTabPage.getShoutoutsGivenCard();

    }
    @Test
    public void shoutoutsRecivedTab(){
        ActivityTabPage activityTabPage = new ActivityTabPage(driver);
        activityTabPage.getShoutoutsReceivedCard();
    }
    @Test
    public void csatResponses(){
        ActivityTabPage activityTabPage = new ActivityTabPage(driver);
        activityTabPage.getCsatResponsesCard();
    }
    @Test
    public void activitySincethelastmeeting() throws InterruptedException {
        ActivityTabPage activityTabPage = new ActivityTabPage(driver);
         activityTabPage.getDateRangeDropdown();
         Thread.sleep(2000);
    }
}
