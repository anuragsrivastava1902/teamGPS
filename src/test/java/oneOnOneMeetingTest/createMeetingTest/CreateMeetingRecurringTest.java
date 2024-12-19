package oneOnOneMeetingTest.createMeetingTest;

import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.homePage.meetings.oneOnOneMeetings.MeetingListingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.CreateEventPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.EditMeetingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.RepeatPatternPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.SelectTemplatePage;

import java.time.Duration;

public class CreateMeetingRecurringTest extends BaseTest {

//    private static final String USERNAME = "lucas.sarzo@yopmail.com";
//    private static final String PASSWORD = "John@123";

    private static final String MEETING_RECIPIENT = "Shri";
    private static final String MEETING_TITLE = "1:1 meeting with Shri 2nd top";

    @BeforeClass
    public void commonState(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMeetings();
        homePage.clickOnOneOnOneMeetings();
        MeetingListingPage meetingListingPage = new MeetingListingPage(driver);
        meetingListingPage.clickCreateMeeting();
        CreateEventPage createEventPage = new CreateEventPage(driver);
        createEventPage.addRecipient(MEETING_RECIPIENT);
        createEventPage.setEventTitle(MEETING_TITLE);
    }


    @Test(priority = 1)
    public void testDailyRecurringMeeting() throws InterruptedException {
        CreateEventPage createEventPage = new CreateEventPage(driver);
        createEventPage.clickOnRecurringMeetingLink();
        RepeatPatternPage repeatPatternPage = new RepeatPatternPage(driver);
        repeatPatternPage.setStartDate();
        repeatPatternPage.setEndDate();
        repeatPatternPage.selectRecurrencePattern("daily");
        Thread.sleep(5000);
        repeatPatternPage.clickOnOkButton();
    }

    @Test(priority = 2)
    public void testWeeklyRecurringMeeting() throws InterruptedException {
        CreateEventPage createEventPage = new CreateEventPage(driver);
        createEventPage.clickOnRecurringMeetingLink();
        RepeatPatternPage repeatPatternPage = new RepeatPatternPage(driver);
        repeatPatternPage.selectRecurrencePattern("weekly");
        Thread.sleep(5000);
        repeatPatternPage.clickOnOkButton();
    }

    @Test(priority = 3)
    public void testMonthlyRecurringMeeting() throws InterruptedException {
        CreateEventPage createEventPage = new CreateEventPage(driver);
        createEventPage.clickOnRecurringMeetingLink();
        RepeatPatternPage repeatPatternPage = new RepeatPatternPage(driver);
        repeatPatternPage.selectRecurrencePattern("monthly");
        Thread.sleep(5000);
        repeatPatternPage.clickOnOkButton();
    }


}
