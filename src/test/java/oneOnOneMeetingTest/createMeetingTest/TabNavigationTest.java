package oneOnOneMeetingTest.createMeetingTest;

import baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.homePage.meetings.oneOnOneMeetings.MeetingListingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.CreateEventPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.EditMeetingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.GoalsTabPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.SelectTemplatePage;

public class TabNavigationTest extends BaseTest {
    private static final String MEETING_RECIPIENT = "Shri";
    private static final String MEETING_TITLE = "1:1 meeting with Shri 2nd";

    @BeforeClass
    public void createMeeting(){
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
    }

    @Test(priority = 4)
    public void testGoalTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnGoalsTab();
        Thread.sleep(6000);
    }

    @Test(priority = 2)
    public void testTasksTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnTasksTab();
        Thread.sleep(6000);
    }

    @Test(priority = 3)
    public void testActivityTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnActivityTab();
        Thread.sleep(6000);
    }

    @Test(priority = 1)
    public void testScorecareTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnScorecardTab();
        Thread.sleep(6000);
    }

    @Test(priority = 0)
    public void testMeetingSurveyTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnMeetingSurveyTab();
        Thread.sleep(6000);
    }

}
