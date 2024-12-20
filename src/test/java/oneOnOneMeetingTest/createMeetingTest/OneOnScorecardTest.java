package oneOnOneMeetingTest.createMeetingTest;

import baseTest.BaseTest;
import baseTest.HeadlessBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.homePage.meetings.oneOnOneMeetings.MeetingListingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.*;

import java.time.Duration;

public class OneOnScorecardTest extends HeadlessBaseTest {

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
        createEventPage.clickOnCreateButton();

        SelectTemplatePage selectTemplatePage = new SelectTemplatePage(driver);
        selectTemplatePage.clickOnFromScratch();
        selectTemplatePage.clickSaveAndNextButton();
        EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
        editMeetingPage.clickOnScorecardTab();
    }

    @Test(priority = 1,enabled = false)
    public void weeklyScorecard() throws InterruptedException {
        ScorecardTabPage scorecardTabPage = new ScorecardTabPage(driver);
        scorecardTabPage.clickOnWeeklyTab();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void weeklyScorecard2() throws InterruptedException {
        ScorecardTabPage scorecardTabPage = new ScorecardTabPage(driver);
        scorecardTabPage.clickOnWeeklyTab();
        scorecardTabPage.selectDateRangeDropdownOption("View Specific Quarter");
        scorecardTabPage.setSelectMonthDropdown("Quarter 2");
        scorecardTabPage.setSelectYearDropdown("2022");
        scorecardTabPage.setClickOnApply();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void monthlyScorecard() throws InterruptedException {
        ScorecardTabPage scorecardTabPage = new ScorecardTabPage(driver);
        scorecardTabPage.clickOnMonthlyTab();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void quarterlyScorecard() throws InterruptedException {
        ScorecardTabPage scorecardTabPage = new ScorecardTabPage(driver);
        scorecardTabPage.clickOnQuarterlyTab();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void dailyScorecard() throws InterruptedException {
        ScorecardTabPage scorecardTabPage = new ScorecardTabPage(driver);
        scorecardTabPage.clickOnDailyTab();
        Thread.sleep(2000);
    }
}
