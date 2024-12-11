import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.homePage.meetings.oneOnOneMeetings.MeetingListingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.CreateEventPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.EditMeetingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.SelectTemplatePage;

public class CreateMeetingTest extends LoginTest {

    @Test(dependsOnMethods = {"testValidLogin"})
   public void createMeetingTest(){
       HomePage homePage = new HomePage(driver);
       homePage.clickOnMeetings();
       homePage.clickOnOneOnOneMeetings();
       MeetingListingPage oneOnOneMeetingsPage = new MeetingListingPage(driver);
       oneOnOneMeetingsPage.clickCreateMeeting();
       CreateEventPage createEventPage = new CreateEventPage(driver);
       createEventPage.addRecipient("Tanishk");
       createEventPage.setEventTitle("meeting with Tanishk 123");
       createEventPage.clickOnCreateButton();
       SelectTemplatePage selectTemplatePage = new SelectTemplatePage(driver);
       selectTemplatePage.clickOnFromScratch();
       selectTemplatePage.clickSaveAndNextButton();
       EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
       editMeetingPage.clickSaveAndSendUpdateButton();
       editMeetingPage.clickAddToCalendarButton();
       editMeetingPage.clickSkipCalendarButton();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
