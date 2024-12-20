import baseTest.BaseTest;
import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.homePage.meetings.oneOnOneMeetings.MeetingListingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.CreateEventPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.EditMeetingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.GoalsTabPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.SelectTemplatePage;
import pages.loginPage.LoginPage;

public class EndToEndTest extends BaseTest {

	@Test()
	public void test() throws InterruptedException {

//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		driver.get("https://itbd-stage-frontend.team-gps.net/login");
//		driver.manage().window().maximize();

		 //-- Interact with the login page
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
		MeetingListingPage meetingListingPage = new MeetingListingPage(driver);
		//meetingListingPage.clickStartMeeting(1);
		//meetingListingPage.clickEditMeeting(1); // why is it not working with the meeting in the second row or third row
		meetingListingPage.clickCreateMeeting();
		//Thread.sleep(15000);
		//meetingListingPage.clickOnLastPageButton();
		//meetingListingPage.clickOnFirstPageButton();
		//meetingListingPage.clickOnNextPageButton();
		//meetingListingPage.clickOnPreviousPageButton();
		//meetingListingPage.clickCancelMeeting(1);
		//meetingListingPage.selectMeetingByDate("2026","May",21);
		
		//MeetingListingPage meetingListingPage = new MeetingListingPage(driver);
		//meetingListingPage.clickOnCompleteMeetingbutton();


		//-- Interact with the Create Event page of the new One-on-One meeting being created
		CreateEventPage createEventPage = new CreateEventPage(driver);
		createEventPage.addRecipient("Shri");
		createEventPage.setEventTitle("meeting 12 dec");
		//createEventPage.clickOnRecurringMeeting();
		createEventPage.clickOnCreateButton();
		//createEventPage.clickOnCancelButton();


		//-- Interact with the select Template page which comes in second step while creating the meeting
		SelectTemplatePage selectTemplatePage = new SelectTemplatePage(driver);
		selectTemplatePage.clickOnDefaultTemplate();
		selectTemplatePage.clickOnFromScratch();
		//selectTemplatePage.clickOnPreviousButton();
		selectTemplatePage.clickSaveAndNextButton();

		//-- Interact with the Edit Meeting page which comes in third step while creating the meeting
		EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
//		editMeetingPage.clickOnMeetingSurveyTab();
//		editMeetingPage.clickOnCreateTaskButton();
//		editMeetingPage.clickSaveAndSendUpdateButton();
//		editMeetingPage.clickAddToCalendarButton();
//		editMeetingPage.clickSkipCalendarButton();
		//editMeetingPage.clickOnTasksTab();
		editMeetingPage.clickOnGoalsTab();

//		MeetingSurveyTabPage meetingSurveyTabPage = new MeetingSurveyTabPage(driver);
//		meetingSurveyTabPage.clickOnAssignSurveyButton();
//		meetingSurveyTabPage.clickOnMeetingTemplatePreview();
		//meetingSurveyTabPage.clickOnUseTemplate();

		//GoalsTabPage goalsTabPage = new GoalsTabPage(driver);
		//goalsTabPage.clickSearchIcon();

//		SurveyPreviewPage surveyPreviewPage = new SurveyPreviewPage(driver);
//		surveyPreviewPage.clickOnCloseButton();


		//TasksTabPage tasksTabPage = new TasksTabPage(driver);
		//tasksTabPage.searchTaskName("hello");
		//tasksTabPage.clickOnCrateTaskButton();
		//tasksTabPage.clickOnTaskDueDateDropdown();
		//tasksTabPage.clickOnTaskSourceDropdown();
		//tasksTabPage.clickOnTaskStatusDropdown();

//		CreateTasksFlyoutPage createTasksFlyoutPage = new CreateTasksFlyoutPage(driver);
//		createTasksFlyoutPage.enterTaskName("new task by me");
//		createTasksFlyoutPage.enterTaskAssignee("Tanishk Patidar");
//		createTasksFlyoutPage.enterTaskDescription();
//		createTasksFlyoutPage.clickOnTaskDueDate();
		//createTasksFlyoutPage.clickOnSaveButton();
		

		//AgendaTabPage agendaTabPage = new AgendaTabPage(driver);
		//agendaTabPage.clickOnEditAgendaItem(0);
		//agendaTabPage.clickOnDeletAgendaItem();
		//agendaTabPage.clickOnAddNotesToAgendaItems();
		//agendaTabPage.clickOnAddAgendaItemButton("automation agenda",5);

		System.out.println("anurag");
		
		Thread.sleep(10000);

		driver.quit();
	}

}
