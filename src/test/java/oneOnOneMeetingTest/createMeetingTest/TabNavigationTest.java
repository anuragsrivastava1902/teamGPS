package oneOnOneMeetingTest.createMeetingTest;

import baseTest.BaseTest;
import baseTest.HeadlessBaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.homePage.meetings.oneOnOneMeetings.MeetingListingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.*;

public class TabNavigationTest extends HeadlessBaseTest {
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
        logger.info("successfully switched to the meeting survey tab");
        //additional methods for the next tests
        Thread.sleep(6000);
    }

    @Test(priority = 1)
    public void testAssigningTheMeetingSurvey(){
        MeetingSurveyTabPage meetingSurveyTabPage = new MeetingSurveyTabPage(driver);
        meetingSurveyTabPage.clickOnAssignSurveyButton();
        meetingSurveyTabPage.clickOnUseTemplate();
        logger.info("successfully assigned the meeting survey to this meeting");
    }

    @Test(priority = 10)
    public void testScorecareTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnScorecardTab();
        logger.info("successfully switched to the scorecard tab");
        Thread.sleep(6000);
    }

    @Test(priority = 11)
    public void testShowPreviousMeetings() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.showPreviousMeetings();
        logger.info("successfully scrolled to the previous meetings between user and manager");
        Thread.sleep(3000);
    }

    @Test(priority = 20)
    public void testTasksTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnTasksTab();
        logger.info("successfully switched to the Tasks tab");
        Thread.sleep(6000);
    }

    @Test(priority = 21)
    public void testTaskSourceDropdown() throws InterruptedException {
        TasksTabPage tasksTabPage = new TasksTabPage(driver);
        tasksTabPage.clickOnTaskSourceDropdown();
        logger.info("successfully clicked on the source dropdown");
    }

    @Test(priority = 22)
    public void testTaskCreation(){
        TasksTabPage tasksTabPage = new TasksTabPage(driver);
        tasksTabPage.clickOnCrateTaskButton();
        CreateTasksFlyoutPage createTasksFlyoutPage = new CreateTasksFlyoutPage(driver);
        createTasksFlyoutPage.enterTaskName("new task for tanishk");
        createTasksFlyoutPage.enterTaskAssignee("lucas");
        createTasksFlyoutPage.clickOnSaveButton();
        logger.info("successfully created task from the task tab");
    }

    @Test(priority = 30)
    public void testActivityTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnActivityTab();
        logger.info("successfully switched to the Activity tab");
        Thread.sleep(6000);
    }

    @Test(priority = 40)
    public void testGoalTabNavigation() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnGoalsTab();
        logger.info("successfully switched to the Goals tab");
        Thread.sleep(6000);
    }
}
