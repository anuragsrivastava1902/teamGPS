package pages.homePage.meetings.oneOnOneMeetings.createNewMeeting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecurringMeetingPage {
	
WebDriver driver;
WebDriverWait wait;

	
	public RecurringMeetingPage(WebDriver driver){
		this.driver = driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Locators for the pop-up window for making the 1:1 meeting recurring:
	
	By repeatPatternModal = By.xpath("/html/body/ngb-modal-window/div/div");
	By startDateInputField = By.xpath("(//input[@id='meetdate'])[2]");
	By endDateInputField = By.xpath("(//input[@id='end_date'])[2]");
	By startTimeInputField = By.xpath("(//input[@placeholder='Enter start time'])[2]");
	By endTimeInputField = By.xpath("(//input[@placeholder='Enter end time'])[2]");
	By durationDropdown = By.xpath("//ng-select[@placeholder='Duration']//div[@class='ng-value-container']");
	
	// -- "Recurrence Pattern" section in the repeat pattern pop-up window
	By dailyRadioButton = By.xpath("//label[normalize-space()='Daily']");
	By weeklyRadioButton = By.xpath("//label[normalize-space()='Weekly']");
	By monthlyRadioButton = By.xpath("//label[normalize-space()='Monthly']");
	By repeatCustomDaysRadioButton = By.xpath("//label[normalize-space()='Every']");
	By repeatEverydayRadioButton = By.xpath("//label[normalize-space()='Every weekday']");
	
	// -- "Range of recurrence" section in the repeat pattern pop-up window
	By recurrenceRangeStartDatePicker = By.xpath("//input[@id='recurrence_range_start_time']");
	By noEndDateRadioButton = By.xpath("//label[normalize-space()='No end date']");
	By endByRadioButton = By.xpath("//label[normalize-space()='End by :']");
	By endByDatePicker = By.xpath("//input[@id='recurrence_range_end_time']");
	By endAfterRadioButton = By.xpath("//label[normalize-space()='End after :']");	
	
	
	//-- Action methods for interacting with the pop-up window
	WebElement modal;
	
	public void switchToRecurringModal() throws InterruptedException {
		modal = wait.until(ExpectedConditions.elementToBeClickable(repeatPatternModal));
		//Thread.sleep(5000);
		modal.findElement(startDateInputField).click();
	}
	
    public void setStartDate(String date) {
        modal.findElement(startDateInputField).sendKeys(date);
    }

    public void setEndDate(String date) {
        driver.findElement(endDateInputField).sendKeys(date);
    }

    public void setStartTime(String time) {
        driver.findElement(startTimeInputField).sendKeys(time);
    }

    public void setEndTime(String time) {
        driver.findElement(endTimeInputField).sendKeys(time);
    }

    public void selectRecurrencePattern(String pattern) {
        switch (pattern.toLowerCase()) {
            case "daily":
                driver.findElement(dailyRadioButton).click();
                break;
            case "weekly":
                driver.findElement(weeklyRadioButton).click();
                break;
            case "monthly":
                driver.findElement(monthlyRadioButton).click();
                break;
        }
    }
}

