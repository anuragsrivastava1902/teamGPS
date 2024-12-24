package oneononemeetingtest.createmeetingtest;

import basetest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.meetings.oneononemeetings.MeetingListingPage;
import pages.homepage.meetings.oneononemeetings.createnewmeeting.*;

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

    @Test(priority = 0)
    public void testMeetingSurveyTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnMeetingSurveyTab();
        //additional methods for the next tests
        Thread.sleep(6000);
    }

    @Test(priority = 1)
    public void testAssigningTheMeetingSurvey(){
        MeetingSurveyTabPage meetingSurveyTabPage = new MeetingSurveyTabPage(driver);
        meetingSurveyTabPage.clickOnAssignSurveyButton();
        meetingSurveyTabPage.clickOnUseTemplate();

    }

    @Test(priority = 10)
    public void testScorecareTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnScorecardTab();
        Thread.sleep(6000);
    }

    @Test(priority = 11)
    public void testShowPreviousMeetings() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.showPreviousMeetings();
        Thread.sleep(3000);
    }

    @Test(priority = 20)
    public void testTasksTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnTasksTab();
        Thread.sleep(6000);
    }

    @Test(priority = 21)
    public void testTaskSourceDropdown() throws InterruptedException {
        TasksTabPage tasksTabPage = new TasksTabPage(driver);
        tasksTabPage.clickOnTaskSourceDropdown();
    }

    @Test(priority = 22)
    public void testTaskCreation(){
        TasksTabPage tasksTabPage = new TasksTabPage(driver);
        tasksTabPage.clickOnCrateTaskButton();
        CreateTasksFlyoutPage createTasksFlyoutPage = new CreateTasksFlyoutPage(driver);
        createTasksFlyoutPage.enterTaskName("new task for tanishk");
        createTasksFlyoutPage.enterTaskAssignee("lucas");
        createTasksFlyoutPage.clickOnSaveButton();
    }

    @Test(priority = 30)
    public void testActivityTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnActivityTab();
        Thread.sleep(6000);
    }

    @Test(priority = 40)
    public void testGoalTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnGoalsTab();
        Thread.sleep(6000);
    }
}
