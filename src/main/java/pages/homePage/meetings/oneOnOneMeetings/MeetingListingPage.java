package pages.homePage.meetings.oneOnOneMeetings;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MeetingListingPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public MeetingListingPage(WebDriver driver){
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

	//Locators for pagination
	By previousPageButton = By.xpath("//li[@class='pagination-prev page-item disabled ng-star-inserted']");
	By nextPageButton = By.xpath("//li[@class='pagination-next page-item disabled ng-star-inserted']");
	By firstPageButton = By.xpath("//li[@class='pagination-first page-item disabled ng-star-inserted']");
	By lastPageButton = By.xpath("//li[@class='pagination-last page-item disabled ng-star-inserted']");


	//LOCATORS FOR ELEMENTS UNDER ACTION COLUMN
	By hamburgerIcon = By.xpath("//tbody/tr[1]/td[1]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/custom-view-component[1]/app-smart-table-actions[1]/div[1]/a[1]/img[1]");
	By actionsModalWindow = By.xpath("//div[@class='dropdown-menu ng-star-inserted show']");
	//By actionsModalWindow = By.xpath("//span[normalize-space()='Start']");
	By startOptionInModalWindow = By.xpath("//span[normalize-space()='Start']");
	By editMeetingButton = By.xpath("/html/body/app-root/div/div/div/div/div/app-meetings/div/div/div[2]/div/app-meeting-list/div[1]/div/div/ng2-smart-table/table/tbody/tr[1]/td[1]/ng2-smart-table-cell/table-cell-view-mode/div/custom-view-component/app-smart-table-actions/div/div/button[2]");
	By editThisMeetingButton = By.xpath("//button[normalize-space()='Edit This Meeting']");
	By cancelMeetingButton = By.xpath("(//span[contains(text(),'Cancel Meeting')])[1]");
	By cancelThisMeetingButton = By.xpath("(//button[@class='dropdown-item ng-star-inserted'][normalize-space()='Cancel This Meeting'])[1]");
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
		
	
	//How can I put these below locators outside the method?? because they use dynamic value to interact with the page.
	
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
	
	public void clickHamburgerIcon(int row) {	
		WebElement editIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerIcon));
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", editIcon);
		editIcon.click();
	}
	
	public void clickEditMeeting(int row) throws InterruptedException {
		//driver.switchTo().activeElement();
		clickHamburgerIcon(row);
		driver.switchTo().activeElement();
		wait.until(ExpectedConditions.visibilityOfElementLocated(editMeetingButton)).click();
		driver.switchTo().activeElement();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-smart-table-actions/div/div/button[2]/div/div/button[1]"))).click();
	}

	public void clickCancelMeeting(int row) throws InterruptedException {
		//driver.switchTo().activeElement();
		clickHamburgerIcon(row);
		driver.switchTo().activeElement();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cancelMeetingButton)).click();
		//driver.switchTo().activeElement();
		WebElement shorty = wait.until(ExpectedConditions.visibilityOfElementLocated(cancelThisMeetingButton));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",shorty);
	}
	
	public void clickStartMeeting(int row) throws InterruptedException {
		clickHamburgerIcon(row);
	    WebElement modal = driver.switchTo().activeElement();
	    // Wait for the start option to be clickable
	    WebElement startOption = wait.until(ExpectedConditions.elementToBeClickable(startOptionInModalWindow));
	    startOption.click();
	}

	public void clickOnPreviousPageButton(){
		wait.until(ExpectedConditions.elementToBeClickable(previousPageButton)).click();
	}

	public void clickOnNextPageButton(){
		wait.until(ExpectedConditions.elementToBeClickable(nextPageButton)).click();
	}

	public void clickOnFirstPageButton(){
		wait.until(ExpectedConditions.elementToBeClickable(firstPageButton)).click();
	}

	public void clickOnLastPageButton(){
		//scrollDownPageToPaginationButton();
		//WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/div/div/app-meetings/div/div/div[2]/div/app-meeting-list")));
//		JavascriptExecutor js = ((JavascriptExecutor)driver);
//		js.executeScript("arguments[0].scrollIntoView(true);", lastPageButton);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		//wait.until(ExpectedConditions.elementToBeClickable(lastPageButton)).click();
	}

	private void scrollDownPageToPaginationButton() {

	}

}
