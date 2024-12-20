package oneOnOneMeetingTest.createMeetingTest;

import baseTest.BaseTest;
import baseTest.HeadlessBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.homePage.meetings.oneOnOneMeetings.MeetingListingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.CreateEventPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.EditMeetingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.RepeatPatternPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.SelectTemplatePage;

import java.time.Duration;

public class CreateMeetingRecurringTest extends HeadlessBaseTest {

    private static final String MEETING_RECIPIENT = "Shri";
    private static final String MEETING_TITLE = "1:1 meeting with Shri 2nd top";

    @BeforeClass
    public void goToMeetingListingPage(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMeetings();
        homePage.clickOnOneOnOneMeetings();
    }

    @BeforeMethod
    public void commonState(){
        MeetingListingPage meetingListingPage = new MeetingListingPage(driver);
        meetingListingPage.clickCreateMeeting();
        CreateEventPage createEventPage = new CreateEventPage(driver);
        createEventPage.addRecipient(MEETING_RECIPIENT);
        createEventPage.setEventTitle(MEETING_TITLE);
    }

    @AfterMethod
    public void completeTheSteps() throws InterruptedException {
        CreateEventPage createEventPage = new CreateEventPage(driver);
        createEventPage.clickOnCreateButton();
        SelectTemplatePage selectTemplatePage = new SelectTemplatePage(driver);
        selectTemplatePage.clickOnFromScratch();
        selectTemplatePage.clickSaveAndNextButton();
        Thread.sleep(3000);
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnSaveButton();
        editMeetingPage.clickAddToCalendarButton();
        //editMeetingPage.clickSkipCalendarButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        MeetingListingPage meetingListingPage = new MeetingListingPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/div/div/app-meetings/div/div/div[1]/div/div")));
        Assert.assertTrue(meetingListingPage.isMeetingDisplayed(MEETING_TITLE), "Meeting was not created successfully.");
   }


    @Test(priority = 1)
    public void testCreateDailyRecurringMeeting() throws InterruptedException {
        CreateEventPage createEventPage = new CreateEventPage(driver);
        createEventPage.clickOnRecurringMeetingLink();
        RepeatPatternPage repeatPatternPage = new RepeatPatternPage(driver);
        repeatPatternPage.setStartDate();
        repeatPatternPage.setEndDate();
        repeatPatternPage.selectRecurrencePattern("daily");
        Thread.sleep(2000);
        repeatPatternPage.clickOnOkButton();
    }

    @Test(priority = 2)
    public void testCreateWeeklyRecurringMeeting() throws InterruptedException {
        CreateEventPage createEventPage = new CreateEventPage(driver);
        createEventPage.clickOnRecurringMeetingLink();
        RepeatPatternPage repeatPatternPage = new RepeatPatternPage(driver);
        repeatPatternPage.selectRecurrencePattern("weekly");
        Thread.sleep(2000);
        repeatPatternPage.clickOnOkButton();
    }

    @Test(priority = 3)
    public void testCreateMonthlyRecurringMeeting() throws InterruptedException {
        CreateEventPage createEventPage = new CreateEventPage(driver);
        createEventPage.clickOnRecurringMeetingLink();
        RepeatPatternPage repeatPatternPage = new RepeatPatternPage(driver);
        repeatPatternPage.selectRecurrencePattern("monthly");
        Thread.sleep(2000);
        repeatPatternPage.clickOnOkButton();
    }


}
