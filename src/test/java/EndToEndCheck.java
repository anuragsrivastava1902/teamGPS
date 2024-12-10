import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.homePage.meetings.oneOnOneMeetings.OneOnOneMeetingsPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.*;
import pages.loginPage.LoginPage;

public class EndToEndCheck extends BaseTest {



	@Test
	public static void test() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://itbd-stage-frontend.team-gps.net/login");
		driver.manage().window().maximize();

		// -- Interact with the login page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("lucas.sarzo@yopmail.com");
		loginPage.clickNextButton();
		loginPage.enterPassword("John@123");
		loginPage.clickLoginButton();

		// -- Interact with the Main page which comes after the login
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMeetings();
		homePage.clickOnOneOnOneMeetings();

		// -- Interact with the One-on-One meeting page which opens after clicking the 1:1 meeting from the left menu
		OneOnOneMeetingsPage oneOnOneMeetingsPage = new OneOnOneMeetingsPage(driver);
		//oneOnOneMeetingsPage.clickStartMeeting(1);
		//oneOnOneMeetingsPage.clickEditMeeting(1); // why is it not working with the meeting in the second row or third row
		oneOnOneMeetingsPage.clickCreateMeeting();
		
		//OngoingMeetingPage ongoingMeetingPage = new OngoingMeetingPage(driver);
		//ongoingMeetingPage.clickOnCompleteMeetingbutton();


		// -- Interact with the Create Event page of the new One-on-One meeting being created
		CreateEventPage createEventPage = new CreateEventPage(driver);
		createEventPage.addRecipient("Tanishk");
		createEventPage.setEventTitle("meeting with ralph and phil 08 nov");
		//createEventPage.clickOnRecurringMeeting();
		createEventPage.clickOnCreateButton();

		//-- Interact with the select Template page which comes in second step while creating the meeting
		SelectTemplatePage selectTemplatePage = new SelectTemplatePage(driver);
		selectTemplatePage.clickDefaultTemplate();
		selectTemplatePage.clickSaveAndNextButton();

		//-- Interact with the Edit Meeting page which comes in third step while creating the meeting
		EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
		editMeetingPage.clickMeetingSurveyTab();
		MeetingSurveyTabPage meetingSurveyTabPage = new MeetingSurveyTabPage(driver);
		//meetingSurveyTabPage.clickOnMeetingTemplatePreview();
		meetingSurveyTabPage.clickOnUseTemplate();
		//editMeetingPage.clickOnCreateTaskButton();
		//editMeetingPage.clickSaveAndSendUpdateButton();
		// editMeetingPage.clickAddToCalendarButton();
		//editMeetingPage.clickSkipCalendarButton();

		//CreateTasksFlyoutPage createTasksFlyoutPage = new CreateTasksFlyoutPage(driver);
		//createTasksFlyoutPage.enterTaskName("new task by me");
		//createTasksFlyoutPage.enterTaskAssignee("Tanishk Patidar");
		

//				AgendaTabPage agendaPage = new AgendaTabPage(driver);
//				agendaPage.clickOnEditAgendaItem(2);

		System.out.println("anurag");
		
		Thread.sleep(10000);

		driver.quit();
	}

}
