package pages.homePage.meetings.oneOnOneMeetings.editMeeting;

import org.openqa.selenium.By;

public class EditMeetingPage {
	
	//locators
	
	By meetingTitleInputField = By.xpath("//input[@class='ng-pristine ng-valid ng-touched']");
	
	By agendaTab = By.xpath("(//a[normalize-space()='Meeting Survey'])[1]");
	By meetingSurveyTab = By.xpath("(//a[normalize-space()='Meeting Survey'])[1]");
	By tasksTab = By.xpath("(//a[normalize-space()='Tasks'])[2]");
	By activityTab = By.xpath("(//a[normalize-space()='Activity'])[1]");
	By goalsTab = By.xpath("(//a[normalize-space()='Goals'])[2]");
	
	By createTaskTab = By.xpath("//span[normalize-space()='Create Task']");
	
	By repeatPatternBtn = By.xpath("//div[@class='timeDiv pointer']");
	
	//Locators in Agenda Tab
	By editAgendaItems = By.xpath("//div[3]//div[1]//div[5]//span[1]//img[1]");
	By deleteAgendaItems = By.xpath("//div[3]//div[1]//div[5]//span[2]//img[1]");
	By addAgendaItem = By.xpath("//div[normalize-space()='+Add Agenda Item']");

	//Locators in Meeting Survey Tab
	By assignSurveyBtn = By.xpath("(//button[normalize-space()='Assign survey'])[1]");
	
	
	By startMeetingBtn = By.xpath("//button[normalize-space()='Start 1:1']");
	By completeMeetingBtn = By.xpath("//button[normalize-space()='Complete 1:1']");
	
	By saveAndSendUpdateBtn = By.xpath("//button[normalize-space()='Save & Send Update']");
	
}
