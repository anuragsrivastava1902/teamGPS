package createMeetingTest;

import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.homePage.meetings.oneOnOneMeetings.MeetingListingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.CreateEventPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.EditMeetingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.SelectTemplatePage;

import java.time.Duration;

public class CreateMeetingTest2 extends BaseTest {

//    private static final String USERNAME = "lucas.sarzo@yopmail.com";
//    private static final String PASSWORD = "John@123";

    private static final String MEETING_RECIPIENT = "Shri";
    private static final String MEETING_TITLE = "1:1 meeting with Shri 2nd";


    @Test
   public void testCreateMeetingWithDefaultTemplate(){

//       LoginPage loginPage = new LoginPage(driver);
//       loginPage.login(USERNAME,PASSWORD);

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
        selectTemplatePage.clickOnDefaultTemplate();
       selectTemplatePage.clickSaveAndNextButton();

       EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
       editMeetingPage.clickSaveAndSendUpdateButton();
       editMeetingPage.clickAddToCalendarButton();
       editMeetingPage.clickSkipCalendarButton();
        /*try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/div/div/app-meetings/div/div/div[1]/div/div")));

        Assert.assertTrue(meetingListingPage.isMeetingDisplayed(MEETING_TITLE), "Meeting was not created successfully.");
    }


}
