package teamGps.homePage.meetings.oneOnOneMeetings.createNewMeeting;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditMeetingPage {

	WebDriver driver;
	WebDriverWait wait;

	public EditMeetingPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Locators
	// We have to take considerations of the scenario, where the meeting being
	// created is not between the employee and his manager

	By meetingTitle = By.xpath("//input[@class='ng-pristine ng-valid ng-touched']");

	By agendaTab = By.xpath("//a[contains('Agenda')]");
	By meetingSurveyTab = By.xpath("//a[contains('Meeting Survey')]");
	By tasksTab = By.xpath("//a[@id='ngb-nav-6']");

	By createTaskTab = By.xpath("//span[normalize-space()='Create Task']");

	By repeatPatternBtn = By.xpath("//div[@class='timeDiv pointer']");

	By editAgendaItems = By.xpath("//div[3]//div[1]//div[5]//span[1]//img[1]");
	By deleteAgendaItems = By.xpath("//div[3]//div[1]//div[5]//span[2]//img[1]");

	By saveAndSendUpdateButton = By.xpath("//button[normalize-space()='Save & Send Update']");
	By addToCalendarSkipbutton = By.xpath("//button[normalize-space()='Skip']");
	By addToCalendarButton = By.xpath("//button[normalize-space()='Add to Calendar']");

	// Action methods
	
	public void clickAgendaTab() {
		wait.until(ExpectedConditions.elementToBeClickable(agendaTab));
		driver.findElement(agendaTab).click();
	}

	public void clickMeetingSurveyTab() {
		wait.until(ExpectedConditions.elementToBeClickable(meetingSurveyTab));
		driver.findElement(meetingSurveyTab).click();
	}

	public void clickSaveAndSendUpdateButton() {
		try {
			WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(saveAndSendUpdateButton));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
		} catch (NoSuchElementException e) {
			System.out.println("Save and Send Update Button not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void clickAddToCalendarButton() {
		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));
		// Locate the "Add to Calendar" button within the modal
		WebElement addButton = modal.findElement(addToCalendarButton);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addButton);
	}

	public void clickSkipCalendarButton() {
		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));
		// Locate the "skip" button within the modal
		WebElement skipButton = modal.findElement(addToCalendarSkipbutton);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", skipButton);
	}

}
