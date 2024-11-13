package teamGps;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import teamGps.homePage.HomePage;
import teamGps.homePage.meetings.oneOnOneMeetings.OneOnOneMeetingsPage;
import teamGps.homePage.meetings.oneOnOneMeetings.createNewMeeting.CreateEventPage;
import teamGps.homePage.meetings.oneOnOneMeetings.createNewMeeting.EditMeetingPage;
import teamGps.homePage.meetings.oneOnOneMeetings.createNewMeeting.SelectTemplatePage;
import teamGps.loginPage.LoginPage;

public class EndToEndCheck {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://itbd-dev-frontend.team-gps.net/login");
		driver.manage().window().maximize();

		// -- Interact with the login page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("lucas.sarzo@yopmail.com").clickNextButton().enterPassword("John@123").clickLoginButton();

		// -- Interact with the Main page which comes after the login
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMeetings();
		homePage.clickOnOneonOneMeetings();

		// -- Interact with the One-on-One meeting page which opens after clicking the 1:1 meeting from the left menu
		OneOnOneMeetingsPage oneOnOneMeetingsPage = new OneOnOneMeetingsPage(driver);
		//oneOnOneMeetingsPage.clickStartMeeting(1);
		oneOnOneMeetingsPage.clickCreateMeeting();


		// -- Interact with the Create Event page of the new One-on-One meeting being created
		CreateEventPage createEventPage = new CreateEventPage(driver);
		createEventPage.addRecipient("Sergio");
		createEventPage.setEventTitle("meeting with ralph and phil 08 nov");
		//createEventPage.clickOnRecurringMeeting();
		createEventPage.clickOnCreateButton();

		//-- Interact with the select Template page which comes in second step while creating the meeting
		SelectTemplatePage selectTemplatePage = new SelectTemplatePage(driver);
		selectTemplatePage.clickDefaultTemplate();
		selectTemplatePage.clickSaveAndNextButton();

		//-- Interact with the Edit Meeting page which comes in third step while creating the meeting
		EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
		editMeetingPage.clickSaveAndSendUpdateButton();
		// editMeetingPage.clickAddToCalendarButton();
		editMeetingPage.clickSkipCalendarButton();
		

//				AgendaTabPage agendaPage = new AgendaTabPage(driver);
//				agendaPage.clickOnEditAgendaItem(2);

		System.out.println("anurag");
		
		Thread.sleep(4000);

		driver.quit();
	}

}
