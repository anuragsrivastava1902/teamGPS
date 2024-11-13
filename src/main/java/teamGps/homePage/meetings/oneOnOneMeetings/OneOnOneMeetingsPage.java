package teamGps.homePage.meetings.oneOnOneMeetings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneOnOneMeetingsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public OneOnOneMeetingsPage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//locators
	int rowNumber;
	By myMeetingsTab = By.xpath("//button[normalize-space()='My Meetings']");
	By allMeetingsTab = By.xpath("/html/body/app-root/div/div/div/div/div/app-meetings/div/div/div[2]/div/app-meeting-list/form/div/div/div[1]/ul/li[2]/button");  
	By createNewMeetingButton = By.xpath("//button[normalize-space()='Create New Meeting']");
	
	By meetingCreatorDropdown = By.xpath("//div[contains(text(),'Meeting Creator')]");
	By meetingRecipientDropdown = By.xpath("//ng-select[@placeholder='Meeting Recipient']//div[@class='ng-value-container']");
	By meetingStatusDropdown = By.xpath("//div[@class='ng-select-container ng-has-value']//span[@class='ng-arrow-wrapper']");
	By meetingFrequencyDropdown = By.xpath("//ng-select[@placeholder='Frequency']//div[@class='ng-value-container']");
	By meetingDatepicker = By.xpath("//input[@id='start_date']");
	
	By sortByMeetingCreator = By.xpath("//a[normalize-space()='Meeting Creator']");
	By sortByMeetingRecipient = By.xpath("//a[normalize-space()='Meeting Recipient']");
	By sortByMeetingTitle = By.xpath("//a[normalize-space()='Meeting Title']");
	By sortByFrequency = By.xpath("//th[@class='ng2-smart-th frequency ng-star-inserted']");
	
	By previousPageButton = By.xpath("//li[@class='pagination-prev page-item disabled ng-star-inserted']");
	By nextPageButton = By.xpath("//li[@class='pagination-next page-item disabled ng-star-inserted']");
	By firstPageButton = By.xpath("//li[@class='pagination-first page-item disabled ng-star-inserted']");
	By lastPageButton = By.xpath("//li[@class='pagination-last page-item disabled ng-star-inserted']");
	
	By hamburgerIcon = By.xpath("(//img[@alt='edit-icon'])[1]");
	By actionsModalWindow = By.xpath("//div[@class='dropdown-menu ng-star-inserted show']");
	//By actionsModalWindow = By.xpath("//span[normalize-space()='Start']");
	By startOptionInModalWindow = By.xpath("//span[normalize-space()='Start']");
	By editMeetingButton = By.xpath("//span[contains(text(),'Edit Meeting')]");
	By editThisMeetingButton = By.xpath("//button[normalize-space()='Edit This Meeting']");
	int meetingRowNumber;
	
	//By goToMeetingBtn = By.xpath("//tbody/tr["+meetingRowNumber+"]/td[7]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/custom-view-component[1]/app-button-action[1]/div[1]/button[1]");
	
	
	
	//By.xpath("//tbody/tr[3]/td[1]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/custom-view-component[1]/app-smart-table-actions[1]/div[1]/a[1]/img[1]");
	
	
	//--------------------------------------------------------------------------------------------------------------
	
	
	//Actions
	
	public void clickMyMeeting() {
		driver.findElement(myMeetingsTab).click();;
	}
	
	public void clickAllMeeting() {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(allMeetingsTab)));
		driver.findElement(allMeetingsTab).click();
	}
	
	public void clickCreateMeeting() {
		driver.findElement(createNewMeetingButton).click();;
	}
	 
	public void clickMeetingCreatorDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(meetingCreatorDropdown)));
		driver.findElement(meetingCreatorDropdown).click();
	}
	
	public void clickMeetingRecipientDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(meetingRecipientDropdown)));
		driver.findElement(meetingRecipientDropdown).click();
	}
	
	public void clickMeetingStatusDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(meetingStatusDropdown)));
		driver.findElement(meetingStatusDropdown).click();
	}
	
	public void clickMeetingFrequencyDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(meetingFrequencyDropdown)));
		driver.findElement(meetingFrequencyDropdown).click();
	}
		
	
	//How can I put these below locators outside the method?? because it uses dynamic value.
	
	public void clickJoinMeetingBtn(int rowNumber) {
		meetingRowNumber = rowNumber;
		By joinMeetingBtn = By.xpath("//tbody/tr["+meetingRowNumber+"]/td[7]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/custom-view-component[1]/app-button-action[1]/div[1]/button[1]");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(joinMeetingBtn)));
		driver.findElement(joinMeetingBtn).click();
	}
	
	public void clickGoToMeetingBtn(int rowNumber) {
		meetingRowNumber = rowNumber;
		By goToMeetingBtn = By.xpath("//tbody/tr["+meetingRowNumber+"]/td[7]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/custom-view-component[1]/app-button-action[1]/div[1]/button[1]");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(goToMeetingBtn)));
		driver.findElement(goToMeetingBtn).click();
	}
	
	public void clickActionBtn(int row) {
		rowNumber = row;
		By meetingActionBtn = By.xpath("//tbody/tr["+rowNumber+"]/td[1]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/custom-view-component[1]/app-smart-table-actions[1]/div[1]/a[1]/img[1]");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(meetingActionBtn)));
		driver.findElement(meetingActionBtn);	
	}
	
	public void clickEditMeeting(int row) throws InterruptedException {
		rowNumber = row;
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(hamburgerIcon)));
		driver.findElement(hamburgerIcon).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(editMeetingButton))).click();;
		//driver.findElement(editMeetingBtn).click();
		Thread.sleep(2000);
		driver.findElement(editThisMeetingButton).click();
	}
	
	public void clickStartMeeting(int n) throws InterruptedException {
	    // Wait for the edit icon to be visible and click
	    WebElement editIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='edit-icon'])[" + n + "]")));
	    editIcon.click();
	    // Wait for the modal to be visible and interactable
	    WebElement modal = wait.until(ExpectedConditions.presenceOfElementLocated(actionsModalWindow));
	    // Wait for the start option to be clickable
	    WebElement startOption = wait.until(ExpectedConditions.elementToBeClickable(startOptionInModalWindow));
	    startOption.click();
	}

	
}
