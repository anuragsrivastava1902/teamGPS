package oneononemeetingtest.createmeetingtest;

import basetest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.meetings.oneononemeetings.MeetingListingPage;
import pages.homepage.meetings.oneononemeetings.createnewmeeting.CreateEventPage;
import pages.homepage.meetings.oneononemeetings.createnewmeeting.EditMeetingPage;
import pages.homepage.meetings.oneononemeetings.createnewmeeting.SelectTemplatePage;

public class PreviousNotesAndPrivateMeetingsTest extends BaseTest {

    private static final String MEETING_RECIPIENT = "Shri";
    private static final String MEETING_TITLE = "1:1 meeting with Shri 2nd";

    @BeforeClass
    public void createMeeting(){
        System.out.println("Using WebDriver in CreateMeetingTest: " + driver.hashCode());
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
    public void testPreviousCompletedMeetings() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.showPreviousMeetings();
        Thread.sleep(5000);
       }

    @Test(priority = 1)
    public void testCreatingPrivateNotes() throws InterruptedException {
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        try {
            editMeetingPage.createPrivateNotes();
        } catch (Exception e) {
            System.out.println("there is an error creating the notes");
        }
    }

}
