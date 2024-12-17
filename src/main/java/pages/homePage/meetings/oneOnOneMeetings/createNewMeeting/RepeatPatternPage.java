package pages.homePage.meetings.oneOnOneMeetings.createNewMeeting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RepeatPatternPage {
	
WebDriver driver;
WebDriverWait wait;

	
	public RepeatPatternPage(WebDriver driver){
		this.driver = driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Locators for the pop-up window for making the 1:1 meeting recurring:
	By repeatPatternModalWindow = By.xpath("/html/body/ngb-modal-window/div/div");
	By startDateInputField = By.xpath("(//input[@id='meetdate'])[2]");
	By endDateInputField = By.xpath("(//input[@id='end_date'])[2]");
	By startTimeInputField = By.xpath("(//input[@placeholder='Enter start time'])[2]");
	By endTimeInputField = By.xpath("(//input[@placeholder='Enter end time'])[2]");
	By meetingDurationDropdown = By.xpath("//ng-select[@placeholder='Duration']//div[@class='ng-value-container']");
	
	// -- Locators for the "Recurrence Pattern" section in the repeat pattern pop-up window
	By dailyRecurrenceRadioButton = By.xpath("//label[normalize-space()='Daily']");
	By weeklyRecurrenceRadioButton = By.xpath("//label[normalize-space()='Weekly']");
	By monthlyRecurrenceRadioButton = By.xpath("//label[normalize-space()='Monthly']");
	By repeatCustomDaysRadioButton = By.xpath("//label[normalize-space()='Every']");
	By repeatEverydayRadioButton = By.xpath("//label[normalize-space()='Every weekday']");
	
	// -- Locators for the "Range of recurrence" section in the repeat pattern pop-up window
	By recurrenceRangeStartDatePicker = By.xpath("//input[@id='recurrence_range_start_time']");
	By noEndDateRadioButton = By.xpath("//label[normalize-space()='No end date']");
	By endByRadioButton = By.xpath("//label[normalize-space()='End by :']");
	By recurrenceRangeEndDatePicker = By.xpath("//input[@id='recurrence_range_end_time']");
	By endAfterRadioButton = By.xpath("//label[normalize-space()='End after :']");	
	
	
	//-- Action methods for interacting with the pop-up window
	WebElement modal;
	
	public void switchToRecurringModal() throws InterruptedException {
		modal = wait.until(ExpectedConditions.elementToBeClickable(repeatPatternModalWindow));
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
                driver.findElement(dailyRecurrenceRadioButton).click();
                break;
            case "weekly":
                driver.findElement(weeklyRecurrenceRadioButton).click();
                break;
            case "monthly":
                driver.findElement(monthlyRecurrenceRadioButton).click();
                break;
        }
    }
}

